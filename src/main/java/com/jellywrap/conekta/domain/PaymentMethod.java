/**
 * 
 */
package com.jellywrap.conekta.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author Jesus Mata
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "object")
@JsonSubTypes({ @Type(value = CardPayment.class, name = "card_payment"),
        @Type(value = OXXOPayment.class, name = "cash_payment") })
public abstract class PaymentMethod {

    protected String object;

    /**
     * @param object
     */
    public PaymentMethod(String object) {

	super();
	this.object = object;
    }

    public String getObject() {

	return object;
    }

    public void setObject(String object) {

	this.object = object;
    }

}
