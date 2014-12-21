/**
 * 
 */
package com.jellywrap.conekta.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesus Mata
 *
 */
public class Charge {

    /** Description of the charge **/
    private String description;

    /** Amount of the charge. Amount charged in cents (no decimal point and the last 2 digits of the number are the cents). **/
    private int amount;

    /**
     * Currency with which to carry out the charge. Use the 3 letter code from <a
     * href="http://en.wikipedia.org/wiki/ISO_4217">International Standard ISO 4217</a>.
     **/
    private String currency;

    /** Unique identifier that can be used to find records associated with this charge. **/
    @JsonProperty(value = "reference_id", required = false)
    private String referenceID;

    /**
     * String with the card to be charged. You can pass a card, an ID of a customer or a token, which you can obtain using
     * conekta.js. To learn more about how to obtain a card ID, client ID or a token, please see the tutorial on subscription.
     **/
    private String card;

    /** Object with all the information to make cash payment (required only for cash payment, eg OXXO). **/
    private Cash cash;

    /**
     * A boolean value that indicates whether the charge will be processed immediately or pre-authorized to be captured later
     * with a capture call.
     **/
    private boolean capture;

    /**
     * Object containing additional information related to the purchase. This is used heavily to detect fraudulent card payments
     * but can also be used to store purchase information for your own use.
     */
    private ChargeDetails details;

    /**
     * 
     * @return The description of the charge
     */
    public String getDescription() {

	return description;
    }

    /**
     * 
     * @param description
     *            Description of the charge
     */
    public void setDescription(String description) {

	this.description = description;
    }

    /**
     * 
     * @return
     */
    public int getAmount() {

	return amount;
    }

    /**
     * 
     * @param amount
     */
    public void setAmount(int amount) {

	this.amount = amount;
    }

    /**
     * 
     * @return
     */
    public String getCurrency() {

	return currency;
    }

    /**
     * 
     * @param currency
     */
    public void setCurrency(String currency) {

	this.currency = currency;
    }

    /**
     * 
     * @return
     */
    public String getReferenceID() {

	return referenceID;
    }

    /**
     * 
     * @param referenceID
     */
    public void setReferenceID(String referenceID) {

	this.referenceID = referenceID;
    }

    /**
     * 
     * @return
     */
    public String getCard() {

	return card;
    }

    /**
     * 
     * @param card
     */
    public void setCard(String card) {

	this.card = card;
    }

    /**
     * Indicates whether the charge will be processed immediately or pre-authorized to be captured later with a capture call
     * 
     * @return true if the charge must be captured immediately
     */
    public boolean isCapture() {

	return capture;
    }

    /**
     * Set to true if the charge must be captured immediately, otherwise the charge must be captured with a capture call
     * 
     * @param capture
     */
    public void setCapture(boolean capture) {

	this.capture = capture;
    }

    /**
     * 
     * @return
     */
    public ChargeDetails getDetails() {

	return details;
    }

    /**
     * 
     * @param details
     */
    public void setDetails(ChargeDetails details) {

	this.details = details;
    }

    public Cash getCash() {

	return cash;
    }

    public void setCash(Cash cash) {

	this.cash = cash;
    }

    @Override
    public String toString() {

	return "Charge [description=" + description + ", amount=" + amount + ", currency=" + currency + ", referenceID="
	        + referenceID + ", card=" + card + ", capture=" + capture + ", details=" + details + "]";
    }

    public class Cash {

	private String type;

	@JsonProperty("expires_at")
	private String expiresAt;

	public String getType() {

	    return type;
	}

	public void setType(String type) {

	    this.type = type;
	}

	public String getExpiresAt() {

	    return expiresAt;
	}

	public void setExpiresAt(String expiresAt) {

	    this.expiresAt = expiresAt;
	}

    }

}
