/**
 * 
 */
package com.jellywrap.conekta.domain;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Jesus Mata
 *
 */
public enum ChargeStatus {
    PENDING_PAYMENT("pending_payment"), PAID("paid"), CHARGED_BACK("charged_back"), REFUNDED("refunded"), PRE_AUTHORIZED("pre_authorized");

    private String value;

    /**
     * @param value
     */
    private ChargeStatus(String value) {

	this.value = value;
    }

    /**
     * @return the value
     */
    @JsonValue
    public String getValue() {

	return value;
    }
}
