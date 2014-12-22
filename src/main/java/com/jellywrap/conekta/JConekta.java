/**
 * 
 */
package com.jellywrap.conekta;

import org.apache.http.auth.UsernamePasswordCredentials;

import com.jellywrap.conekta.rest.RestClient;

/**
 * @author Jesus Mata
 *
 */
public class JConekta {

    private static JConekta instance;

    private RestClient restClient;

    /**
     * 
     */
    private JConekta() {

    }

    /**
     * 
     * @return
     */
    public static JConekta getInstance() {

	if (instance == null) {
	    synchronized (JConekta.class) {
		if (instance == null) {
		    instance = new JConekta();
		}
	    }
	}
	return instance;
    }

    public void setAPIKey(String apiKey) {

	restClient = new RestClient(new UsernamePasswordCredentials(apiKey));
	restClient.setBaseUrl("https://api.conekta.io/");
    }

}
