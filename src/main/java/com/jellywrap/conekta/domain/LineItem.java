/**
 * 
 */
package com.jellywrap.conekta.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesus Mata
 *
 */
public class LineItem {

    private String name;

    private String description;

    private String sku;

    @JsonProperty("unit_price")
    private int unitPrice;

    private int quantity;

    private String type;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getSku() {
	return sku;
    }

    public void setSku(String sku) {
	this.sku = sku;
    }

    public int getUnitPrice() {
	return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
	this.unitPrice = unitPrice;
    }

    public int getQuantity() {
	return quantity;
    }

    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

}
