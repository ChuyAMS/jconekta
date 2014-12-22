/**
 * 
 */
package com.jellywrap.conekta.query;

import java.util.List;

import com.jellywrap.conekta.rest.RequestParam;

/**
 * @author Jesus Mata
 *
 */
public interface Query {

    public String getQueryString();

    public List<RequestParam> getParams();

}
