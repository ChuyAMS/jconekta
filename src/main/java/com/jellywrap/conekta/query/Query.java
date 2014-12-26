/**
 * 
 */
package com.jellywrap.conekta.query;

import java.util.Collection;

import com.jellywrap.conekta.rest.RequestParam;

/**
 * @author Jesus Mata
 *
 */
public interface Query {

    public String getQueryString();
    
    public Collection<RequestParam> getParams();

}
