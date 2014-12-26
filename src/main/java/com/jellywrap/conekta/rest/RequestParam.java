package com.jellywrap.conekta.rest;

import org.apache.http.NameValuePair;

/**
 * Represents a rquest parameter on a HTTP request
 * 
 * @author Jesus Mata
 *
 */
public class RequestParam implements NameValuePair {

    private String name;

    private String value;

    public RequestParam(String name, String value) {

	super();
	this.name = name;
	this.value = value;
    }

    @Override
    public String getName() {

	return name;
    }

    @Override
    public String getValue() {

	return value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

	return name + "=" + value;
    }

}
