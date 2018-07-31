/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.config.Environment;
import com.rave.config.RaveConstant;
import com.rave.function.RecurringPayment;

/**
 *
 * @author Tess
 */
public class Test {
    public static void main(String [] args)throws Exception{
    
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;
//        
//        SubAccount sub = new SubAccount();
//        
//        sub.setAccount_bank("044");
//        sub.setAccount_number("0690000035");
//        sub.setAmount("1000");
//        sub.setBusiness_contact("Seun Alade");
//        sub.setBusiness_name("JK Services");
//        sub.setBusiness_contact_mobile("090890382");
//        sub.setBusiness_email("sogunledolapo@gmail.com");
//        sub.setBusiness_mobile("09087930450");
//        sub.setMetaname("MarketplaceID");
//        sub.setMetavalue("ggs-920900");
//        
//        System.out.println(sub.initiateSubaccountPayment());
        
        RecurringPayment rp = new RecurringPayment();
        rp.setAmount("1000");
        rp.setDuration("3");
        rp.setInterval("monthly");
        rp.setName("Theresa");
        
        System.out.println(rp.createPaymentPlan());
        
      
        
    }
}
