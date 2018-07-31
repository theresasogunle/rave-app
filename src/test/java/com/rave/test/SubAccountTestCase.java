/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.function.SubAccount;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Tess
 */
public class SubAccountTestCase {
      @org.junit.Test
    public void testSubAccount() {

        SubAccount sb = new SubAccount();
       sb.setAccount_bank("044");
       sb.setAccount_number("0690000035");
       sb.setAmount("500");
       sb.setBusiness_contact("Seun Alade");
       sb.setBusiness_contact_mobile("09089038");
       sb.setBusiness_email("jk@services.com");
       sb.setBusiness_name("JK Services");
       sb.setBusiness_mobile("09087930450");
       sb.setMetaname("MarketplaceID");
       sb.setMetavalue("ggs-920900");
       
       

        JSONObject response = sb.initiateSubaccountPayment();
        if (response.get("status").equals("success")) {
            assertEquals(response.get("status"), "success");

            System.out.println(response);
        } else {
            assertEquals(response.get("status"), "error");
            System.out.println(response);

        }

    }

}
