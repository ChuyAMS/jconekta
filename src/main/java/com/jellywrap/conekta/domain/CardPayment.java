/**
 * 
 */
package com.jellywrap.conekta.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesus Mata
 *
 */
public class CardPayment extends PaymentMethod {

    private String name;

    @JsonProperty("exp_year")
    private String expYear;

    @JsonProperty("exp_month")
    private String expMonth;

    @JsonProperty("auth_code")
    private String authCode;

    private String last4;

    private String brand;

    /**
     * 
     */
    public CardPayment() {

	super("card_payment");
    }

    public String getName() {

	return name;
    }

    public void setName(String name) {

	this.name = name;
    }

    public String getExpYear() {

	return expYear;
    }

    public void setExpYear(String expYear) {

	this.expYear = expYear;
    }

    public String getExpMonth() {

	return expMonth;
    }

    public void setExpMonth(String expMonth) {

	this.expMonth = expMonth;
    }

    public String getAuthCode() {

	return authCode;
    }

    public void setAuthCode(String authCode) {

	this.authCode = authCode;
    }

    public String getLast4() {

	return last4;
    }

    public void setLast4(String last4) {

	this.last4 = last4;
    }

    public String getBrand() {

	return brand;
    }

    public void setBrand(String brand) {

	this.brand = brand;
    }

    @Override
    public String toString() {

	return "CardPayment [name=" + name + ", expYear=" + expYear + ", expMonth=" + expMonth + ", authCode=" + authCode
	        + ", last4=" + last4 + ", brand=" + brand + ", object=" + getObject() + "]";
    }

}
