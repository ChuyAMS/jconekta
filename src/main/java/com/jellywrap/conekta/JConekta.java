/**
 * 
 */
package com.jellywrap.conekta;

import org.apache.http.auth.UsernamePasswordCredentials;

import com.jellywrap.conekta.rest.RestClient;
import com.jellywrap.conekta.service.ChargeService;
import com.jellywrap.conekta.service.ChargeServiceImpl;

/**
 * @author Jesus Mata
 *
 */
public class JConekta {

    private static JConekta instance;

    private static RestClient restClient;

    private ChargeService chargeService;

    /**
     * 
     */
    private JConekta() {

	if (restClient == null) {
	    throw new IllegalStateException("Private API key must be provided first");
	}
	chargeService = new ChargeServiceImpl(restClient);
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

    public static void setAPIKey(String apiKey) {

	restClient = new RestClient(new UsernamePasswordCredentials(apiKey,""));
	restClient.setBaseUrl("https://api.conekta.io/");
    }

    /**
     * @return the chargeService
     */
    public ChargeService getChargeService() {

	return chargeService;
    }

}
