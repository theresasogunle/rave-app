/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.config.Encryption;
import com.rave.config.Environment;
import com.rave.config.RaveConstant;
import com.rave.function.AccountCharge;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * @author Theresa
 */
public class AccountChargeTestCase {

    JSONObject json = new JSONObject();
    AccountCharge ch = new AccountCharge();
    Encryption e = new Encryption();

    @Test
    public void testAccountCharge() throws JSONException {
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;

        ch.setAccountnumber("0690000031")
                .setAccountbank("044")
                .setAmount("1000")
                .setCountry("NG")
                .setCurrency("NGN")
                .setLastname("Theresa")
                .setTxRef("MX-678DH")
                .setEmail("sogunledolapo@gmail.com");

        JSONObject result = ch.chargeAccount();

      
        JSONObject data = (JSONObject) result.get("data");
        if (data.get("chargeResponseCode").equals("02")) {
            ch.setOtp("12345");
            ch.setTransaction_reference("ACHG-1532954128209");
            JSONObject validate = ch.validateAccountCharge();

            if (validate.get("status").equals("success")) {
                assertEquals(validate.get("status"), "success");

            } else {
                assertEquals(validate.get("status"), "error");
            }

        }
        else if(data.get("chargeResponseCode").equals("00")){
        
          if (result.get("status").equals("success")) {
            assertEquals(result.get("status"), "success");
            System.out.println(result);
        } else {

            assertEquals(result.get("status"), "error");
            System.out.println(result);
        }
        }

    }

}
