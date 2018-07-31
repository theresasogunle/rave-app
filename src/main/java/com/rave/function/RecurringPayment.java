/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.function;

import com.rave.config.ApiConnection;
import com.rave.config.ApiQuery;
import com.rave.config.Encryption;
import static com.rave.config.Encryption.encryptData;
import com.rave.config.Endpoint;
import com.rave.config.RaveConstant;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Tess
 */
public class RecurringPayment {

    private String cardno;
    private String cvv;
    private String expirymonth;
    private String expiryyear;
    private String currency;
    private String country;
    private String pin;
    private String billingzip;
    private String billingcity;
    private String billingaddress;
    private String billingstate;
    private String billingcountry;
    private String amount;
    private String email;
    private String interval;
    private String duration;
    private String name;
    private String phonenumber;
    private String firstname;
    private String lastname;
    private String txRef;
    private String redirect_url;
    private String device_fingerprint;
    private String IP;
    private String metaname;
    private String metavalue;
    private String charge_type;
    private String payment_plan;
    ApiConnection apiConnection;
    Endpoint ed = new Endpoint();
    Encryption e = new Encryption();

    private JSONObject meta = new JSONObject();

    public JSONObject setJSON() throws JSONException{
        JSONObject json = new JSONObject();
        

            json.put("cardno", this.getCardno());
            json.put("cvv", this.getCvv());
            json.put("currency", this.getCurrency());
            json.put("country", this.getCountry());
            json.put("amount", this.getAmount());
            json.put("expiryyear", this.getExpiryyear());
            json.put("expirymonth", this.getExpirymonth());
            json.put("email", this.getEmail());
            json.put("txRef", this.getTxRef());
            json.put("device_fingerprint", this.getDevice_fingerprint());
            json.put("meta", getMeta());
            getMeta().put("metaname", this.getMetaname());
            getMeta().put("metavalue", this.getMetavalue());
            json.put("firstname", this.getFirstname());
            json.put("lastname", this.getLastname());
            json.put("redirect_url", this.getRedirect_url());
            json.put("charge_type", this.getCharge_type());
            json.put("payment_plan", this.getPayment_plan());
       
        return json;
    }

    public JSONObject createPaymentPlan() {
        this.apiConnection = new ApiConnection(ed.getCreatePaymentPlanEndpoint());
        ApiQuery api = new ApiQuery();

        api.putParams("amount", this.getAmount());
        api.putParams("name", this.getName());
        api.putParams("seckey", RaveConstant.SECRET_KEY);
        api.putParams("interval", this.getInterval());
        api.putParams("duration", this.getDuration());

        return this.apiConnection.connectAndQuery(api);

    }

    public JSONObject charge() {

        JSONObject json = setJSON();

        String message = json.toString();

        String encrypt_secret_key = Encryption.getKey(RaveConstant.SECRET_KEY);
        String client = encryptData(message, encrypt_secret_key);

        Charge ch = new Charge();

        return ch.charge(client);

    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the interval
     */
    public String getInterval() {
        return interval;
    }

    /**
     * @param interval the interval to set
     */
    public void setInterval(String interval) {
        this.interval = interval;
    }

    /**
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return the payment_plan
     */
    public String getPayment_plan() {
        return payment_plan;
    }

    /**
     * @param payment_plan the payment_plan to set
     */
    public void setPayment_plan(String payment_plan) {
        this.payment_plan = payment_plan;
    }

    /**
     * @return the metaname
     */
    public String getMetaname() {
        return metaname;
    }

    /**
     * @param metaname the metaname to set
     */
    public void setMetaname(String metaname) {
        this.metaname = metaname;
    }

    /**
     * @return the metavaluel
     */
    public String getMetavalue() {
        return metavalue;
    }

    /**
     * @param metavalue the metavalue to set
     */
    public void setMetavalue(String metavalue) {
        this.metavalue = metavalue;
    }

    /**
     * @return the txRef
     */
    public String getTxRef() {
        return txRef;
    }

    /**
     * @param txRef the txRef to set
     */
    public void setTxRef(String txRef) {
        this.txRef = txRef;
    }

    /**
     * @return the meta
     */
    public JSONObject getMeta() {
        return meta;
    }

    /**
     * @param meta the meta to set
     */
    public void setMeta(JSONObject meta) {
        this.meta = meta;
    }

    /**
     * @return the cardno
     */
    public String getCardno() {
        return cardno;
    }

    /**
     * @param cardno the cardno to set
     */
    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    /**
     * @return the cvv
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * @param cvv the cvv to set
     */
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    /**
     * @return the expirymonth
     */
    public String getExpirymonth() {
        return expirymonth;
    }

    /**
     * @param expirymonth the expirymonth to set
     */
    public void setExpirymonth(String expirymonth) {
        this.expirymonth = expirymonth;
    }

    /**
     * @return the expiryyear
     */
    public String getExpiryyear() {
        return expiryyear;
    }

    /**
     * @param expiryyear the expiryyear to set
     */
    public void setExpiryyear(String expiryyear) {
        this.expiryyear = expiryyear;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the pin
     */
    public String getPin() {
        return pin;
    }

    /**
     * @param pin the pin to set
     */
    public void setPin(String pin) {
        this.pin = pin;
    }

    /**
     * @return the billingzip
     */
    public String getBillingzip() {
        return billingzip;
    }

    /**
     * @param billingzip the billingzip to set
     */
    public void setBillingzip(String billingzip) {
        this.billingzip = billingzip;
    }

    /**
     * @return the billingcity
     */
    public String getBillingcity() {
        return billingcity;
    }

    /**
     * @param billingcity the billingcity to set
     */
    public void setBillingcity(String billingcity) {
        this.billingcity = billingcity;
    }

    /**
     * @return the billingaddress
     */
    public String getBillingaddress() {
        return billingaddress;
    }

    /**
     * @param billingaddress the billingaddress to set
     */
    public void setBillingaddress(String billingaddress) {
        this.billingaddress = billingaddress;
    }

    /**
     * @return the billingstate
     */
    public String getBillingstate() {
        return billingstate;
    }

    /**
     * @param billingstate the billingstate to set
     */
    public void setBillingstate(String billingstate) {
        this.billingstate = billingstate;
    }

    /**
     * @return the billingcountry
     */
    public String getBillingcountry() {
        return billingcountry;
    }

    /**
     * @param billingcountry the billingcountry to set
     */
    public void setBillingcountry(String billingcountry) {
        this.billingcountry = billingcountry;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phonenumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * @param phonenumber the phonenumber to set
     */
    public RecurringPayment setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        return this;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
        
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public  void setLastname(String lastname) {
        this.lastname = lastname;
        
    }

    /**
     * @return the redirect_url
     */
    public String getRedirect_url() {
        return redirect_url;
    }

    /**
     * @param redirect_url the redirect_url to set
     */
    public RecurringPayment setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
        return this;
    }

    /**
     * @return the device_fingerprint
     */
    public String getDevice_fingerprint() {
        return device_fingerprint;
    }

    /**
     * @param device_fingerprint the device_fingerprint to set
     */
    public void setDevice_fingerprint(String device_fingerprint) {
        this.device_fingerprint = device_fingerprint;
       
    }

   
    /**
     * @return the charge_type
     */
    public String getCharge_type() {
        return charge_type;
    }

    /**
     * @param charge_type the charge_type to set
     * @return RecurringPayment
     */
    public void setCharge_type(String charge_type) {
        this.charge_type = charge_type;
        
    }

}
