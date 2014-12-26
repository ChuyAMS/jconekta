/**
 * 
 */
package com.jellywrap.conekta.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.apache.http.HttpHeaders;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jellywrap.conekta.exception.ConektaApiException;
import com.jellywrap.conekta.exception.ErrorMessage;

/**
 * A basic RESTFul client used to perform operations against <a href="https://www.conekta.io/es/docs/api/">Conekta<a/>
 * 
 * @author Jesus Mata
 *
 */
public class RestClient {

    /** The HTTP client to connect to the REST API **/
    private final CloseableHttpClient httpClient;

    /** The base URI of the REST API **/
    private URI baseUrl;

    /** The Jackson Mapper used to marshal/unmarshal JSON **/
    private final ObjectMapper mapper;

    private final BasicHeader JSON_CONTENT_HEADER = new BasicHeader(HTTP.CONTENT_TYPE, "application/json");

    /**
     * 
     * @param usernamePasswordCredentials
     */
    public RestClient(UsernamePasswordCredentials usernamePasswordCredentials) {

	PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
	cm.setDefaultMaxPerRoute(2);
	HttpClientBuilder builder = HttpClientBuilder.create();
	builder.setConnectionManager(cm);

	RequestConfig rc = RequestConfig.custom().setConnectTimeout(10000).setCookieSpec(CookieSpecs.BEST_MATCH).build();
	builder.setDefaultRequestConfig(rc);

	try {
	    InputStream is = RestClient.class.getClassLoader().getResourceAsStream("ssl/ca_bundle.crt");
	    CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
	    X509Certificate cert = (X509Certificate) certificateFactory.generateCertificate(is);
	    TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
	    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
	    ks.load(null);
	    ks.setCertificateEntry("caCert", cert);
	    tmf.init(ks);

	    SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(ks).build();
	    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
	    builder.setSSLSocketFactory(sslsf);
	} catch (CertificateException | NoSuchAlgorithmException | KeyStoreException | IOException | KeyManagementException e) {
	    e.printStackTrace();
	}

	CredentialsProvider cp = new BasicCredentialsProvider();
	cp.setCredentials(new AuthScope(null, AuthScope.ANY_PORT), usernamePasswordCredentials);
	builder.setDefaultCredentialsProvider(cp);
	httpClient = builder.build();

	mapper = new ObjectMapper();
	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	mapper.setSerializationInclusion(Include.NON_NULL);
    }

    /**
     * 
     * @param baseUrl
     */
    public void setBaseUrl(String baseUrl) {

	try {
	    this.baseUrl = new URI(baseUrl);
	} catch (URISyntaxException e) {
	    throw new IllegalArgumentException("Not a valid URL");
	}
    }

    /**
     * 
     * @param url
     * @param params
     * @param excpected
     * @return
     */
    public <E> E doGetForObject(String url, Collection<RequestParam> params, Class<E> excpected) {

	try {
	    String result = doGet(url, params);
	    return mapper.readValue(result, excpected);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return null;
    }

    /**
     * 
     * @param url
     * @param excpected
     * @return
     */
    public <E> E doGetForObject(String url, Class<E> excpected) {

	return doGetForObject(url, null, excpected);
    }

    /**
     * 
     * @param url
     * @param params
     * @param excpectedListType
     * @return
     */
    public <E> List<E> doGetForList(String url, Collection<RequestParam> params, Class<E> excpectedListType) {

	try {
	    String result = doGet(url, params);
	    return mapper.readValue(result, mapper.getTypeFactory().constructCollectionType(List.class, excpectedListType));
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return null;
    }

    /**
     * 
     * @param url
     * @param excpectedListType
     * @return
     */
    public <E> List<E> doGetForList(String url, Class<E> excpectedListType) {

	return doGetForList(url, null, excpectedListType);
    }

    /**
     * 
     * @param url
     * @return
     */
    public String doGet(String url) {

	return doGet(url, null);
    }

    /**
     * 
     * @param url
     * @param params
     * @return
     */
    public String doGet(String url, Collection<RequestParam> params) {

	CloseableHttpResponse response = null;
	try {
	    URIBuilder uriBuilder = new URIBuilder(baseUrl).setPath((url.startsWith("/") ? url : "/" + url));
	    if (params != null) {
		for (RequestParam param : params) {
		    uriBuilder = uriBuilder.addParameter(param.getName(), param.getValue());
		}
	    }
	    URI uri = uriBuilder.build();

	    HttpGet httpget = new HttpGet(uri);

	    response = httpClient.execute(httpget);
	    return EntityUtils.toString(response.getEntity());
	} catch (ClientProtocolException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (URISyntaxException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    closeResponse(response);
	}
	return url;
    }

    /**
     * 
     * @param url
     * @param payLoad
     * @param excpected
     * @return
     */
    public <E> E doPost(String url, Object payLoad, Class<E> excpected) {

	try {
	    String jsonPayLoad = mapper.writeValueAsString(payLoad);
	    String result = doPost(url, jsonPayLoad);
	    return mapper.readValue(result, excpected);
	} catch (JsonProcessingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // Cannot parse result to expected class
	    e.printStackTrace();
	}

	return null;

    }

    /**
     * 
     * @param url
     * @param payLoad
     * @return
     */
    public String doPost(String url, String payLoad) {

	if (!url.startsWith("/")) {
	    url = "/" + url;
	}

	CloseableHttpResponse response = null;
	try {
	    URI uri = new URIBuilder(baseUrl).setPath(url).build();
	    HttpPost httpPost = new HttpPost(uri);
	    httpPost.addHeader(HttpHeaders.ACCEPT, "application/vnd.conekta-v0.3.0+json");
	    httpPost.getParams().setBooleanParameter("http.protocol.expect-continue", false);

	    StringEntity entity = new StringEntity(payLoad, "UTF-8");

	    entity.setContentType(JSON_CONTENT_HEADER);
	    httpPost.setEntity(entity);

	    response = httpClient.execute(httpPost);
	    String result = EntityUtils.toString(response.getEntity());
	    if (result.contains("{\"object\":\"error\"")) {
		throw new ConektaApiException(mapper.readValue(result, ErrorMessage.class));
	    }
	    return result;
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (URISyntaxException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    closeResponse(response);
	}

	return null;

    }

    /**
     * 
     * @param response
     */
    private void closeResponse(CloseableHttpResponse response) {

	if (response == null) return;
	try {
	    response.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
