/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.function.RecurringPayment;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Tess
 */
public class RecurringPaymentTestCase {

    @Test
    public void testCreatePaymentPlan() {

        RecurringPayment py = new RecurringPayment();
        py.setAmount("700");
        py.setName("Wunmi");
        py.setInterval("monthly");
        py.setDuration("3");
        py.setBillingaddress("Lagos");
        py.setBillingcountry("Nigeria");
        py.setBillingstate("Nigerua");
        py.setBillingzip("112002");
        

        JSONObject response = py.createPaymentPlan();
        if (response.get("status").equals("success")) {
            assertEquals(response.get("status"), "success");

            System.out.println(response);
        } else {
            assertEquals(response.get("status"), "error");
            System.out.println(response);

        }

    }

    @Test
    public void testChargeRecurringPayment() {

        RecurringPayment py = new RecurringPayment();
        py.setCardno("4556052704172643");
        py.setCvv("899");
        py.setCurrency("NGN");
        py.setCountry("NG");
        py.setAmount("9000");
        py.setExpiryyear("19");
        py.setExpirymonth("01");
        py.setEmail("sogunledolapo@gmail.com");
        py.setTxRef("MXX-ASC-4578");
        py.setRedirect_url("");
        py.setPayment_plan("13");
        py.setPhonenumber("09027891737");

        JSONObject response = py.charge();
        if (response.get("status").equals("success")) {
            assertEquals(response.get("status"), "success");

            System.out.println(response);
        } else {
            assertEquals(response.get("status"), "error");
            System.out.println(response);

        }

    }
}
