/**
 * 
 */
package com.jellywrap.conekta.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jellywrap.conekta.ChargeFields;
import com.jellywrap.conekta.JConekta;
import com.jellywrap.conekta.domain.Charge;
import com.jellywrap.conekta.domain.Charge.Cash;
import com.jellywrap.conekta.domain.ChargeDetails;
import com.jellywrap.conekta.domain.ChargeResponse;
import com.jellywrap.conekta.domain.ChargeStatus;
import com.jellywrap.conekta.query.Query;
import com.jellywrap.conekta.query.QueryBuilder;

/**
 * @author Jesus Mata
 *
 */
public class ChargeServiceImplTest {

    private static ChargeService chargeService;

    private final String TEST_CARD = "tok_test_visa_4242";

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

	// RestClient restClient = new RestClient(new UsernamePasswordCredentials("key_xJH25p11gGkH6pME", ""));
	// restClient.setBaseUrl("https://api.conekta.io/");

	JConekta.setAPIKey("key_xJH25p11gGkH6pME");
	JConekta conekta = JConekta.getInstance();

	chargeService = conekta.getChargeService();
    }

    /**
     * Test method for {@link com.jellywrap.conekta.service.ChargeServiceImpl#charge(com.jellywrap.conekta.domain.Charge)}.
     */
    @Test
    public void testCharge() {

	Charge charge = new Charge();
	charge.setDescription("test charge");
	charge.setAmount(25000);
	charge.setCurrency("MXN");
	charge.setReferenceID("testCharge reference");
	charge.setCard(TEST_CARD);
	ChargeResponse response = chargeService.charge(charge);
	assertTrue(response.getStatus() == ChargeStatus.PAID);
    }

    /**
     * Test method for {@link com.jellywrap.conekta.service.ChargeServiceImpl#charge(com.jellywrap.conekta.domain.Charge)}.
     */
    @Test
    public void testChargeNonInmediatlyCapture() {

	Charge charge = new Charge();
	charge.setDescription("Charge with no capture");
	charge.setAmount(25710);
	charge.setCurrency("MXN");
	charge.setReferenceID("testCharge reference");
	charge.setCard(TEST_CARD);
	charge.setCapture(false);
	ChargeResponse response = chargeService.charge(charge);
	assertTrue(response.getStatus() == ChargeStatus.PRE_AUTHORIZED);
    }

    /**
     * Test method for {@link com.jellywrap.conekta.service.ChargeServiceImpl#charge(com.jellywrap.conekta.domain.Charge)}.
     */
    @Test
    public void testAdvancedCharge() {

	Charge charge = new Charge();
	charge.setDescription("Charge as Advanced Call");
	charge.setAmount(25710);
	charge.setCurrency("MXN");
	charge.setReferenceID("test advanced call reference");
	charge.setCard(TEST_CARD);

	// Advanced call extra attrs
	ChargeDetails details = new ChargeDetails();
	details.setCustomerName("Jesus Mata");
	details.setEmail("some@email.com");
	details.setPhone("415-25-59");
	details.setDateOfBirth("2014-08-24");
	charge.setDetails(details);
	ChargeResponse response = chargeService.charge(charge);
	assertTrue(response.getStatus() == ChargeStatus.PAID);
    }

    @Test
    public void testOxxoCharge() throws Exception {

	Charge charge = new Charge();
	charge.setDescription("OXXO Payment");
	charge.setAmount(450000);
	charge.setCurrency("MXN");
	charge.setCash(new Cash());
	ChargeDetails details = new ChargeDetails();
	details.setCustomerName("Jesus Mata");
	details.setEmail("some@email.com");
	details.setPhone("415-25-59");
	charge.setDetails(details);
	charge.setReferenceID("oxxo ref");
	ChargeResponse response = chargeService.charge(charge);
	assertTrue(response.getStatus() == ChargeStatus.PENDING_PAYMENT);
    }

    /**
     * Test method for {@link com.jellywrap.conekta.service.ChargeServiceImpl#retrieve(java.lang.String)}.
     */
    @Test
    public void testRetrieve() {

	ChargeResponse created = createCharge();

	ChargeResponse retrieved = chargeService.retrieve(created.getId());
	assertTrue(retrieved.getId().equals(created.getId()));
    }

    /**
     * Test method for {@link com.jellywrap.conekta.service.ChargeServiceImpl#refund(java.lang.String)}.
     */
    @Test
    public void testRefundString() {

	ChargeResponse response = createCharge();
	ChargeResponse refunded = chargeService.refund(response.getId());
	assertTrue(refunded.equals(response));
	assertEquals("Status is not refunded", refunded.getStatus(), ChargeStatus.REFUNDED);
    }

    /**
     * Test method for {@link com.jellywrap.conekta.service.ChargeServiceImpl#refund(java.lang.String, java.lang.Integer)}.
     */
    @Test
    public void testRefundStringInteger() {

	// fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.jellywrap.conekta.service.ChargeServiceImpl#capture(java.lang.String)}.
     */
    @Test
    public void testCapture() {

	Charge charge = new Charge();
	charge.setDescription("Charge with no capture for later capture");
	charge.setAmount(25710);
	charge.setCurrency("MXN");
	charge.setReferenceID("testCharge reference");
	charge.setCard(TEST_CARD);
	charge.setCapture(false);
	ChargeResponse notCaptured = chargeService.charge(charge);
	assertTrue(notCaptured.getStatus() == ChargeStatus.PRE_AUTHORIZED);

	ChargeResponse captured = chargeService.capture(notCaptured.getId());
	assertTrue(captured.equals(notCaptured));
	assertTrue(captured.getStatus() == ChargeStatus.PAID);
    }

    /**
     * Test method for {@link com.jellywrap.conekta.service.ChargeServiceImpl#query(com.jellywrap.conekta.query.Query)}.
     */
    @Test
    public void testQuery() {

	Query query = new QueryBuilder().ne(ChargeFields.STATUS, "paid").gt(ChargeFields.AMOUNT, "10000").limit(10).build();
	List<ChargeResponse> chargeResponses = chargeService.query(query);
	assertTrue(chargeResponses.size() == 10);
	for (ChargeResponse chargeResponse : chargeResponses) {
	    assertTrue(chargeResponse.getStatus() != ChargeStatus.PAID);
	    assertTrue(chargeResponse.getAmount() > 10000);
	}
    }

    /**
     * 
     */
    private ChargeResponse createCharge() {

	// Create charge
	Charge charge = new Charge();
	charge.setDescription("test charge");
	charge.setAmount(25000);
	charge.setCurrency("MXN");
	charge.setReferenceID("testCharge reference");
	charge.setCard(TEST_CARD);
	ChargeResponse created = chargeService.charge(charge);
	assertTrue(created.getStatus() == ChargeStatus.PAID);
	return created;

    }

}
