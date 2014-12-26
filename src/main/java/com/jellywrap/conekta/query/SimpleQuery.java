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
public class SimpleQuery implements Query {

    private Collection<RequestParam> params;

    private String queryString;

    public SimpleQuery(Collection<RequestParam> params) {

	super();
	this.params = params;

	StringBuffer buffer = new StringBuffer();
	for (RequestParam requestParam : params) {
	    buffer = buffer.append(requestParam.toString() + "&");
	}
	queryString = buffer.substring(0, buffer.length() - 1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jellywrap.conekta.query.Query#getQueryString()
     */
    @Override
    public String getQueryString() {

	return queryString;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jellywrap.conekta.query.Query#getParams()
     */
    @Override
    public Collection<RequestParam> getParams() {

	return params;
    }

}
