/**
 * 
 */
package com.jellywrap.conekta.service;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jellywrap.conekta.JConekta;
import com.jellywrap.conekta.domain.Charge;
import com.jellywrap.conekta.domain.ChargeResponse;
import com.jellywrap.conekta.domain.ChargeStatus;
import com.jellywrap.conekta.exception.ConektaApiException;

/**
 * @author Jesus Mata
 *
 */
public class FailureAuthenticationTest {

    private static ChargeService chargeService;

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

	JConekta.setAPIKey("none");
	JConekta conekta = JConekta.getInstance();

	chargeService = conekta.getChargeService();
    }

    @Test
    public void testFailureAuth() throws Exception {

	try {
	    Charge charge = new Charge();
	    charge.setDescription("test charge");
	    charge.setAmount(25000);
	    charge.setCurrency("MXN");
	    charge.setReferenceID("testCharge reference");
	    charge.setCard("tok_test_card_declined");
	    ChargeResponse response = chargeService.charge(charge);
	    assertTrue(response.getStatus() == ChargeStatus.PAID);
	} catch (ConektaApiException ex) {
	    assertTrue("Unrecognized access key.".equals(ex.getErrorMessageObject().getMessage()));
	}
    }
}
