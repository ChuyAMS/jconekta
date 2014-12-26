/**
 * 
 */
package com.jellywrap.conekta.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.jellywrap.conekta.LocalDateTimeEpochJsonDeserializer;

/**
 * Represents the response of a charge request. It includes some extra attributes that may not be used on a charge request
 * 
 * @author Jesus Mata
 *
 */
/**
 * @author Jesus Mata
 *
 */
/**
 * @author Jesus Mata
 *
 */
public class ChargeResponse extends Charge {

    private String id;

    @JsonProperty(value = "livemode")
    private boolean liveMode;

    @JsonProperty(value = "created_at")
    private String createdAt;

    private ChargeStatus status;

    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;

    @JsonProperty("failure_code")
    private String failureCode;

    @JsonProperty("failure_message")
    private String failureMessage;

    private Integer fee;

    @JsonProperty("customer_id")
    private String customerID;

    @JsonProperty("paid_at")
    @JsonDeserialize(using = LocalDateTimeEpochJsonDeserializer.class)
    private LocalDateTime paidAt;

    public String getId() {

	return id;
    }

    public void setId(String id) {

	this.id = id;
    }

    public boolean isLiveMode() {

	return liveMode;
    }

    public void setLiveMode(boolean liveMode) {

	this.liveMode = liveMode;
    }

    public String getCreatedAt() {

	return createdAt;
    }

    public void setCreatedAt(String createdAt) {

	this.createdAt = createdAt;
    }

    public ChargeStatus getStatus() {

	return status;
    }

    public void setStatus(ChargeStatus status) {

	this.status = status;
    }

    public PaymentMethod getPaymentMethod() {

	return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {

	this.paymentMethod = paymentMethod;
    }

    public String getFailureCode() {

	return failureCode;
    }

    public void setFailureCode(String failureCode) {

	this.failureCode = failureCode;
    }

    public String getFailureMessage() {

	return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {

	this.failureMessage = failureMessage;
    }

    public Integer getFee() {

	return fee;
    }

    public void setFee(Integer fee) {

	this.fee = fee;
    }

    public String getCustomerID() {

	return customerID;
    }

    public void setCustomerID(String customerID) {

	this.customerID = customerID;
    }

    public LocalDateTime getPaidAt() {

	return paidAt;
    }

    public void setPaidAt(LocalDateTime paidAt) {

	this.paidAt = paidAt;
    }

    @Override
    public int hashCode() {

	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {

	if (this == obj) return true;
	if (obj == null) return false;
	if (getClass() != obj.getClass()) return false;
	ChargeResponse other = (ChargeResponse) obj;
	if (id == null) {
	    if (other.id != null) return false;
	} else if (!id.equals(other.id)) return false;
	return true;
    }

    @Override
    public String toString() {

	return "ChargeResponse [id=" + id + ", liveMode=" + liveMode + ", createdAt=" + createdAt + ", status=" + status
	        + ", paymentMethod=" + paymentMethod + ", failureCode=" + failureCode + ", failureMessage=" + failureMessage
	        + ", fee=" + fee + ", customerID=" + customerID + ", paidAt=" + paidAt + ", description=" + getDescription()
	        + ", amount=" + getAmount() + ", currency=" + getCurrency() + ", referenceID=" + getReferenceID() + ", card="
	        + getCard() + ", capture=" + isCapture() + ", details=" + getDetails() + "]";
    }

}
