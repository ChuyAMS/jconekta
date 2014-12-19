/**
 * 
 */
package com.jellywrap.conekta.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesus Mata
 *
 */
public class BillingAddress {

    @JsonProperty("tax_id")
    private String taxID;

    @JsonProperty("company_name")
    private String companyName;

    private String phone;

    private String email;

    private String street1;

    private String street2;

    private String street3;

    private String city;

    private String state;

    private String country;

    private String zip;

    public String getTaxID() {
	return taxID;
    }

    public void setTaxID(String taxID) {
	this.taxID = taxID;
    }

    public String getCompanyName() {
	return companyName;
    }

    public void setCompanyName(String companyName) {
	this.companyName = companyName;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getStreet1() {
	return street1;
    }

    public void setStreet1(String street1) {
	this.street1 = street1;
    }

    public String getStreet2() {
	return street2;
    }

    public void setStreet2(String street2) {
	this.street2 = street2;
    }

    public String getStreet3() {
	return street3;
    }

    public void setStreet3(String street3) {
	this.street3 = street3;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public String getCountry() {
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    public String getZip() {
	return zip;
    }

    public void setZip(String zip) {
	this.zip = zip;
    }

}
