/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.function;

import com.rave.config.ApiConnection;
import com.rave.config.ApiQuery;
import com.rave.config.Endpoint;
import com.rave.config.RaveConstant;

import org.json.JSONObject;

/**
 *
 * @author Tess
 */
public class Charge {

    ApiConnection apiConnection;
    Endpoint ed = new Endpoint();

    /**
     *
     *
     *
     * @return JSONObject
     */
    public JSONObject charge(String client) {
        this.apiConnection = new ApiConnection(ed.getChargeEndPoint());

        String alg = "3DES-24";

        ApiQuery api = new ApiQuery();

        api.putParams("PBFPubKey", RaveConstant.PUBLIC_KEY);

        api.putParams("client", client);

        api.putParams("alg", alg);

        return this.apiConnection.connectAndQuery(api);
    }

    /**
     *
     *
     * @return JSONObject
     * @param transaction_reference
     * @param otp
     *
     */
    public JSONObject validateAccountCharge(String transaction_reference, String otp) {

        this.apiConnection = new ApiConnection(ed.getValidateAccountChargeEndPoint());

        ApiQuery api = new ApiQuery();

        api.putParams("PBFPubKey", RaveConstant.PUBLIC_KEY);
        api.putParams("transactionreference", transaction_reference);

        api.putParams("otp", otp);

        return this.apiConnection.connectAndQuery(api);
    }

    /**
     *
     *
     * @return JSONObject
     * @param transaction_reference
     * @param otp
     *
     */
    public JSONObject validateCardCharge(String transaction_reference, String otp) {

        this.apiConnection = new ApiConnection(ed.getValidateCardChargeEndPoint());

        ApiQuery api = new ApiQuery();

        api.putParams("PBFPubKey", RaveConstant.PUBLIC_KEY);
        api.putParams("transaction_reference", transaction_reference);

        api.putParams("otp", otp);

        return this.apiConnection.connectAndQuery(api);
    }

}
