package com.jellywrap.conekta.service;

import java.util.List;

import com.jellywrap.conekta.domain.Charge;
import com.jellywrap.conekta.domain.ChargeResponse;
import com.jellywrap.conekta.query.Query;
import com.jellywrap.conekta.rest.RestClient;

public class ChargeServiceImpl implements ChargeService {

    private RestClient restClient;

    public ChargeServiceImpl(RestClient restClient) {

	super();
	this.restClient = restClient;
    }

    @Override
    public ChargeResponse charge(Charge charge) {

	return restClient.doPost("charges", charge, ChargeResponse.class);
    }

    @Override
    public ChargeResponse retrieve(String chargeID) {

	return restClient.doGetForObject("charges/" + chargeID, ChargeResponse.class);
    }

    @Override
    public ChargeResponse refund(String chargeID) {

	return restClient.doPost("charges/" + chargeID + "/refund", "", ChargeResponse.class);
    }

    @Override
    public ChargeResponse refund(String chargeID, Integer amount) {

	return restClient.doPost("charges/" + chargeID + "/refund", "", ChargeResponse.class);
    }

    @Override
    public ChargeResponse capture(String chargeID) {

	return restClient.doPost("charges/" + chargeID + "/capture", "", ChargeResponse.class);
    }

    @Override
    public List<ChargeResponse> query(Query query) {

	return restClient.doGetForList("charges", query.getParams(), ChargeResponse.class);
    }

}
