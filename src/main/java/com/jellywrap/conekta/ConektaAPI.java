/**
 * 
 */
package com.jellywrap.conekta;

import com.jellywrap.conekta.domain.Charge;
import com.jellywrap.conekta.domain.ChargeResponse;
import com.jellywrap.conekta.query.Query;

/**
 * Defines the available calls that could be performed to the Conekta API
 * 
 * @author Jesus Mata
 *
 */
public interface ConektaAPI {

    public ChargeResponse charge(Charge chargeRequest);

    public ChargeResponse retrieve(String chargeID);

    public ChargeResponse refund(String chargeID);

    public ChargeResponse refund(String chargeID, int amount);

    public ChargeResponse capture(String chargeID);

    public ChargeResponse findChargeByID(String chargeID);

    public ChargeResponse query(String queryString);

    public ChargeResponse query(Query query);

}
