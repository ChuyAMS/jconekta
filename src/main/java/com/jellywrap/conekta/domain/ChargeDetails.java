/**
 * 
 */
package com.jellywrap.conekta.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesus Mata
 *
 */
public class ChargeDetails {

    @JsonProperty("name")
    private String customerName;

    private String phone;

    private String email;

    @JsonProperty("date_of_birth")
    private String dateOfBirth;

    @JsonProperty("billing_address")
    private BillingAddress billingAddress;

    @JsonProperty("line_items")
    private List<LineItem> lineItems;

    private Shipment shipment;

    public String getCustomerName() {

	return customerName;
    }

    public void setCustomerName(String customerName) {

	this.customerName = customerName;
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

    public String getDateOfBirth() {

	return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {

	this.dateOfBirth = dateOfBirth;
    }

    public BillingAddress getBillingAddress() {

	return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {

	this.billingAddress = billingAddress;
    }

    public List<LineItem> getLineItems() {

	return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {

	this.lineItems = lineItems;
    }

    public void addLineItem(LineItem lineItem) {

	this.lineItems.add(lineItem);
    }

    public Shipment getShipment() {

	return shipment;
    }

    public void setShipment(Shipment shipment) {

	this.shipment = shipment;
    }

    @Override
    public String toString() {

	return "ChargeDetails [customerName=" + customerName + ", phone=" + phone + ", email=" + email + ", dateOfBirth="
	        + dateOfBirth + ", billingAddress=" + billingAddress + ", lineItems=" + lineItems + ", shipment=" + shipment
	        + "]";
    }

}
