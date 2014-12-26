/**
 * 
 */
package com.jellywrap.conekta.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesus Mata
 *
 */
public class ErrorMessage {

    private String type;

    private String message;

    @JsonProperty("message_to_purchaser")
    private String messageToPurchaser;

    private String code;

    private String param;

    public String getType() {

	return type;
    }

    public void setType(String type) {

	this.type = type;
    }

    public String getMessage() {

	return message;
    }

    public void setMessage(String message) {

	this.message = message;
    }

    public String getMessageToPurchaser() {

	return messageToPurchaser;
    }

    public void setMessageToPurchaser(String messageToPurchaser) {

	this.messageToPurchaser = messageToPurchaser;
    }

    public String getCode() {

	return code;
    }

    public void setCode(String code) {

	this.code = code;
    }

    public String getParam() {

	return param;
    }

    public void setParam(String param) {

	this.param = param;
    }

    @Override
    public String toString() {

	return "ErrorMessage [type=" + type + ", message=" + message + ", messageToPurchaser=" + messageToPurchaser + ", code="
	        + code + ", param=" + param + "]";
    }

}
