/**
 * 
 */
package com.jellywrap.conekta.domain;

/**
 * @author Jesus Mata
 *
 */
public class Address {

    // The first line of the shipment’s destination address. It is usually used for street and number.
    private String street1;

    // The second line of the shipment’s destination address. Usually it is used for internal number, suite, or delegation.
    private String street2;

    // The third line of the shipment’s destination address. For Mexican customers, it is usually used for the ‘colonia’.
    private String street3;

    // The city of the shipment’s destination.
    private String city;

    // The shipment’s destination state.
    private String state;

    // The country of the shipment’s destination. Use ISO 3166-1 standard with 2 digits.
    private String country;

    // Zip/postal code of the shipment’s destination.
    private String zip;

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
