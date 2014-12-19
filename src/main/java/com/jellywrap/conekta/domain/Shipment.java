/**
 * 
 */
package com.jellywrap.conekta.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesus Mata
 *
 */
public class Shipment {

    // The shipping carrier used to send the package e.g. fedex.
    private String carrier;

    // The service used to send the package e.g. next_day.
    private String service;

    // The package tracking_id given by the shipping provider, this can be used to track and confirm delivery of a package.
    @JsonProperty("tracking_id")
    private String trackingID;

    // The price of the shipment.
    private int price;

    private Address address;

    public String getCarrier() {
	return carrier;
    }

    public void setCarrier(String carrier) {
	this.carrier = carrier;
    }

    public String getService() {
	return service;
    }

    public void setService(String service) {
	this.service = service;
    }

    public String getTrackingID() {
	return trackingID;
    }

    public void setTrackingID(String trackingID) {
	this.trackingID = trackingID;
    }

    public int getPrice() {
	return price;
    }

    public void setPrice(int price) {
	this.price = price;
    }

    public Address getAddress() {
	return address;
    }

    public void setAddress(Address address) {
	this.address = address;
    }

}
