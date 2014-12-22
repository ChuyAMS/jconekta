/**
 * 
 */
package com.jellywrap.conekta.service;

import java.util.List;

import com.jellywrap.conekta.domain.Charge;
import com.jellywrap.conekta.domain.ChargeResponse;
import com.jellywrap.conekta.query.Query;

/**
 * @author Jesus Mata
 *
 */
public interface ChargeService {

    ChargeResponse charge(Charge charge);

    ChargeResponse retrieve(String chargeID);

    ChargeResponse refund(String chargeID);

    ChargeResponse refund(String chargeID, Integer amount);

    ChargeResponse capture(String chargeID);

    List<ChargeResponse> query(Query query);

}
