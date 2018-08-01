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
import static com.rave.config.Encryption.getKey;
import com.rave.config.Endpoint;
import com.rave.config.RaveConstant;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Tess
 */
public class CardCharge {
      JSONObject api = new JSONObject();
    Endpoint ed = new Endpoint();
    ApiConnection apiConnection;

    Encryption e = new Encryption();
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
    private String phonenumber;
    private String firstname;
    private String lastname;
    private String txRef;
    private String redirect_url;
    private String device_fingerprint;
    private String IP;
    private String charge_type;
    private int payment_plan;

    private String transactionreference, otp, authUrl;

    /**
     *
     *
     *
     * @return JSONObject
     */
    public JSONObject setJSON() {
        JSONObject json = new JSONObject();
        try {

            json.put("cardno", this.getCardno());
            json.put("cvv", this.getCvv());
            json.put("currency", this.getCurrency());
            json.put("country", this.getCountry());
            json.put("amount", this.getAmount());
            json.put("expiryyear", this.getExpiryyear());
            json.put("expirymonth", this.getExpirymonth());
            json.put("email", this.getEmail());
            json.put("IP", this.getIP());
            json.put("txRef", this.getTxRef());
            json.put("device_fingerprint", this.getDevice_fingerprint());
            json.put("firstname", this.getFirstname());
            json.put("lastname", this.getLastname());
            json.put("redirect_url", this.getRedirect_url());
            json.put("charge_type", this.getCharge_type());
            json.put("payment_plan", this.getPayment_plan());
        } catch (JSONException ex) {
            ex.getMessage();
        }
        return json;
    }

    public JSONObject chargeCard() throws JSONException {
        JSONObject json = setJSON();

        String message = json.toString();
        String encrypt_secret_key = getKey(RaveConstant.SECRET_KEY);
        String client = encryptData(message, encrypt_secret_key);

        Charge ch = new Charge();

        return ch.charge(client);

    }

    public JSONObject recharge(String suggested_auth) throws JSONException {
        JSONObject json = setJSON();
        Charge ch = new Charge();

        JSONObject charge = new JSONObject();
        if (suggested_auth.equals("PIN")) {
            json.put("suggested_auth", suggested_auth);
            System.out.println(suggested_auth);
            json.put("pin", this.getPin());

            String message = json.toString();
            String encrypt_secret_key = getKey(RaveConstant.SECRET_KEY);
            String client = encryptData(message, encrypt_secret_key);
            charge = ch.charge(client);

        } else if (suggested_auth.equalsIgnoreCase("NOAUTH_INTERNATIONAL")||suggested_auth.equalsIgnoreCase("AVS_VBVSECURECODE")) {
            json.put("suggested_auth", suggested_auth);
            json.put("billingzip", this.getBillingzip());
            json.put("billingcity", this.getBillingcity());
            json.put("billingaddress", this.getBillingaddress());
            json.put("billingstate", this.getBillingstate());
            json.put("billingcountry", this.getBillingcountry());
            String message = json.toString();
            String encrypt_secret_key = getKey(RaveConstant.SECRET_KEY);
            String client = encryptData(message, encrypt_secret_key);
            charge = ch.charge(client);
        }
        return charge;
    }

  

    /*
     if AuthMode::"PIN"
     @params transaction reference(flwRef),OTP 
     * @return JSONObject
     */
    public JSONObject validateCardCharge() {
        Charge vch = new Charge();

        return vch.validateCardCharge(this.getTransactionreference(), this.getOtp());
    }

      public JSONObject verify(String txref){
      this.apiConnection = new ApiConnection(ed.getVerifyEndPoint());
      
       ApiQuery api = new ApiQuery();

        api.putParams("SECKEY", RaveConstant.SECRET_KEY);
        api.putParams("txref", txref);
      return this.apiConnection.connectAndQuery(api);
    }

    

  
    /**
     * @return the cardno
     */
    public String getCardno() {
        return cardno;
    }

    /**
     * @param cardno the cardno to set
     * @return CardCharge
     */
    public CardCharge setCardno(String cardno) {
        this.cardno = cardno;

        return this;
    }

    /**
     * @return the cvv
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * @param cvv the cvv to set
     * @return CardCharge
     */
    public CardCharge setCvv(String cvv) {
        this.cvv = cvv;

        return this;
    }

    /**
     * @return the expirymonth
     */
    public String getExpirymonth() {
        return expirymonth;
    }

    /**
     * @param expirymonth the expirymonth to set
     * @return CardCharge
     */
    public CardCharge setExpirymonth(String expirymonth) {
        this.expirymonth = expirymonth;

        return this;
    }

    /**
     * @return the expiryyear
     */
    public String getExpiryyear() {
        return expiryyear;
    }

    /**
     * @param expiryyear the expiryyear to set
     * @return CardCharge
     */
    public CardCharge setExpiryyear(String expiryyear) {
        this.expiryyear = expiryyear;

        return this;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     * @return CardCharge
     */
    public CardCharge setCurrency(String currency) {
        this.currency = currency;

        return this;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     * @return CardCharge
     */
    public CardCharge setCountry(String country) {
        this.country = country;

        return this;
    }

    /**
     * @return the pin
     */
    public String getPin() {
        return pin;
    }

    /**
     * @param pin the pin to set
     * @return CardCharge
     */
    public CardCharge setPin(String pin) {
        this.pin = pin;

        return this;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     * @return CardCharge
     */
    public CardCharge setAmount(String amount) {
        this.amount = amount;

        return this;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     * @return CardCharge
     */
    public CardCharge setEmail(String email) {
        this.email = email;

        return this;
    }

    /**
     * @return the phonenumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * @param phonenumber the phonenumber to set
     * @return CardCharge
     */
    public CardCharge setPhonenumber(String phonenumber) {
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
     * @return CardCharge
     */
    public CardCharge setFirstname(String firstname) {
        this.firstname = firstname;

        return this;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     * @return CardCharge
     */
    public CardCharge setLastname(String lastname) {
        this.lastname = lastname;

        return this;
    }

    /**
     * @return the IP
     */
    public String getIP() {
        return IP;
    }

    /**
     * @param IP the IP to set
     * @return CardCharge
     */
    public CardCharge setIP(String IP) {
        this.IP = IP;

        return this;
    }

    /**
     * @return the txRef
     */
    public String getTxRef() {
        return txRef;
    }

    /**
     * @param txRef the txRef to set
     * @return CardCharge
     */
    public CardCharge setTxRef(String txRef) {
        this.txRef = txRef;

        return this;
    }

    /**
     * @return the redirect_url
     */
    public String getRedirect_url() {
        return redirect_url;
    }

    /**
     * @param redirect_url the redirect_url to set
     * @return CardCharge
     */
    public CardCharge setRedirect_url(String redirect_url) {
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
     * @return CardCharge
     */
    public CardCharge setDevice_fingerprint(String device_fingerprint) {
        this.device_fingerprint = device_fingerprint;

        return this;
    }

    /**
     * @return the charge_type
     */
    public String getCharge_type() {
        return charge_type;
    }

    /**
     * @param charge_type the charge_type to set
     * @return CardCharge
     */
    public CardCharge setCharge_type(String charge_type) {
        this.charge_type = charge_type;

        return this;
    }

    /**
     * @return the transaction_reference
     */
    public String getTransactionreference() {
        return transactionreference;
    }

    /**
     * @param transaction_reference the transaction_reference to set
     * @return CardCharge
     */
    public CardCharge setTransactionreference(String transaction_reference) {
        this.transactionreference = transaction_reference;

        return this;
    }

    /**
     * @return the otp
     */
    public String getOtp() {
        return otp;
    }

    /**
     * @param otp the otp to set
     * @return CardCharge
     */
    public CardCharge setOtp(String otp) {
        this.otp = otp;

        return this;
    }

    /**
     * @return the authUrl
     */
    public String getAuthUrl() {
        return authUrl;
    }

    /**
     * @param authUrl the authUrl to set
     * @return CardCharge
     */
    public CardCharge setAuthUrl(String authUrl) {
        this.authUrl = authUrl;

        return this;
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
     * @return the payment_type
     */
    public int getPayment_plan() {
        return payment_plan;
    }

    /**
     * @param payment_type the payment_type to set
     */
    public CardCharge setPayment_plan(int payment_plan) {
        this.payment_plan = payment_plan;
        return this;
    }
}
