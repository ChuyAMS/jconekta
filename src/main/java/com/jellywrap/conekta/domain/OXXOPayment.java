/**
 * 
 */
package com.jellywrap.conekta.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesus Mata
 *
 */
/**
 * @author Jesus Mata
 *
 */
public class OXXOPayment extends PaymentMethod {

    /**
     * 
     */
    public OXXOPayment() {

	super("cash_payment");
    }

    /**
     * Format: dd/mm/yy
     */
    @JsonProperty("expiry_date")
    private String expiryDate;

    private String barcode;

    @JsonProperty("barcode_url")
    private String barcodeURL;

    private String type;

    public String getExpiryDate() {

	return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {

	this.expiryDate = expiryDate;
    }

    public String getBarcode() {

	return barcode;
    }

    public void setBarcode(String barcode) {

	this.barcode = barcode;
    }

    public String getBarcodeURL() {

	return barcodeURL;
    }

    public void setBarcodeURL(String barcodeURL) {

	this.barcodeURL = barcodeURL;
    }

    public String getType() {

	return type;
    }

    public void setType(String type) {

	this.type = type;
    }

    @Override
    public String toString() {

	return "OXXOPayment [expiryDate=" + expiryDate + ", barcode=" + barcode + ", barcodeURL=" + barcodeURL + ", type="
	        + type + "]";
    }

}
