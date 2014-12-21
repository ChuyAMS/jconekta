/**
 * 
 */
package com.jellywrap.conekta.service;

import java.util.List;

import com.jellywrap.conekta.domain.ChargeResponse;
import com.jellywrap.conekta.query.Query;


/**
 * @author Jesus Mata
 *
 */
public interface QueryService {
    
    public List<ChargeResponse> query(Query query);
    
}
