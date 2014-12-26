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
public class ChargeServiceImplErrorTest {

    private static ChargeService chargeService;

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

	JConekta.setAPIKey("key_xJH25p11gGkH6pME");
	JConekta conekta = JConekta.getInstance();

	chargeService = conekta.getChargeService();
    }

    @Test()
    public void testInvalidCard() {

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
	    assertTrue("The card issuing bank declined to process this charge.".equals(ex.getErrorMessageObject().getMessage()));
	}

    }

    @Test()
    public void testChargeInsufficentFunds() {

	try {
	    Charge charge = new Charge();
	    charge.setDescription("test charge");
	    charge.setAmount(25000);
	    charge.setCurrency("MXN");
	    charge.setReferenceID("testCharge reference");
	    charge.setCard("tok_test_insufficient_funds");
	    ChargeResponse response = chargeService.charge(charge);
	    assertTrue(response.getStatus() == ChargeStatus.PAID);
	} catch (ConektaApiException ex) {
	    assertTrue("This card has insufficient funds to complete the purchase.".equals(ex.getErrorMessageObject()
		    .getMessage()));
	}
    }

}
