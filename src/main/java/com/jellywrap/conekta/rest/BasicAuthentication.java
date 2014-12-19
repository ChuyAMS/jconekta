/**
 * 
 */
package com.jellywrap.conekta.rest;

/**
 * @author Jesus Mata
 *
 */
public class BasicAuthentication {

    private String username;
    private String password;

    public BasicAuthentication(String username, String password) {
	super();
	this.username = username;
	this.password = password;
    }

    public BasicAuthentication(String username) {
	super();
	this.username = username;
    }
}
