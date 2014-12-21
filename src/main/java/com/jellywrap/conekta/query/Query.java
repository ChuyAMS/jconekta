/**
 * 
 */
package com.jellywrap.conekta.query;

import java.util.List;

import org.apache.http.NameValuePair;

/**
 * @author Jesus Mata
 *
 */
public interface Query {

    public String getQueryString();

    public List<NameValuePair> getParams();

}
