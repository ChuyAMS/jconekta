/**
 * 
 */
package com.jellywrap.conekta.exception;

/**
 * @author Jesus Mata
 *
 */
public class ConektaApiException extends RuntimeException {

    private ErrorMessage errorMessageObject;

    /**
     * 
     */
    private static final long serialVersionUID = -1082779581819084937L;

    public ConektaApiException(ErrorMessage msg) {

	super(msg.getMessage());
	this.errorMessageObject = msg;
    }

    /**
     * @return the errorMessageObject
     */
    public ErrorMessage getErrorMessageObject() {

	return errorMessageObject;
    }

}
