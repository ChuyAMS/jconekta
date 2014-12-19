/**
 * 
 */
package com.jellywrap.conekta.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesus Mata
 *
 */
public class ChargeRequest {

    private String description;
    private int amount;
    private String currency;
    @JsonProperty(value = "reference_id", required = false)
    private String referenceID;
    private String card;

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public int getAmount() {
	return amount;
    }

    public void setAmount(int amount) {
	this.amount = amount;
    }

    public String getCurrency() {
	return currency;
    }

    public void setCurrency(String currency) {
	this.currency = currency;
    }

    public String getReferenceID() {
	return referenceID;
    }

    public void setReferenceID(String referenceID) {
	this.referenceID = referenceID;
    }

    public String getCard() {
	return card;
    }

    public void setCard(String card) {
	this.card = card;
    }

    @Override
    public String toString() {
	return "Charge [description=" + description + ", amount=" + amount + ", currency=" + currency + ", referenceID="
		+ referenceID + ", card=" + card + "]";
    }

}
