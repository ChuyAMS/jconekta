/**
 * 
 */
package com.jellywrap.conekta;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jellywrap.conekta.domain.ChargeRequest;
import com.jellywrap.conekta.domain.ChargeResponse;
import com.jellywrap.conekta.rest.RestClient;

/**
 * @author Jesus Mata
 *
 */
public class RestAPIAuthentcationTest {

    private static RestClient restClient;

    private ObjectMapper mapper = new ObjectMapper();

    @BeforeClass
    public static void afterClass() {
	restClient = new RestClient(new UsernamePasswordCredentials("key_xJH25p11gGkH6pME", ""));
	restClient.setBaseUrl("https://api.conekta.io/");
    }

    @Test
    public void testSimpleCharge() throws Exception {
	String payLoad = "{\"description\":\"Stogies\",  \"amount\": 20000,  \"currency\":\"MXN\",  \"reference_id\":\"9839-wolf_pack\",  \"card\": \"tok_test_visa_4242\"}";
	String result = restClient.doPost("charges", payLoad);

	JsonNode jsonNode = mapper.readTree(result);
	assertTrue("Invalid Payment", jsonNode.get("status").asText().equals("paid"));
    }

    @Test
    public void testAdvacedCharge() throws Exception {
	String payLoad = inputStreamToString(this.getClass().getClassLoader()
		.getResourceAsStream("json/advanced_charge_request.json"));
	String result = restClient.doPost("charges", payLoad);

	JsonNode jsonNode = mapper.readTree(result);
	assertTrue("Invalid Payment", jsonNode.get("status").asText().equals("paid"));
    }

    @Test
    public void testSimpleChargeWithObject() throws Exception {
	ChargeRequest payLoad = new ChargeRequest();
	payLoad.setAmount(30000);
	payLoad.setCard("tok_test_visa_4242");
	payLoad.setCurrency("MXN");
	payLoad.setDescription("aasdasd");
	payLoad.setReferenceID("test reference");
	ChargeResponse result = restClient.doPost("charges", payLoad, ChargeResponse.class);
	System.out.println(result);
    }

    private static String inputStreamToString(InputStream in) throws IOException {
	StringBuilder sb = new StringBuilder();
	BufferedReader r = new BufferedReader(new InputStreamReader(in), 1000);
	for (String line = r.readLine(); line != null; line = r.readLine()) {
	    sb.append(line);
	}
	in.close();
	return sb.toString();
    }
}
