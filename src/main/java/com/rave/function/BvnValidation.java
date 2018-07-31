/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.function;

import com.rave.config.ApiConnection;
import com.rave.config.Encryption;
import com.rave.config.Endpoint;
import com.rave.config.RaveConstant;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author Tess
 */
public class BvnValidation {

    private String bvn_number;
    ApiConnection apiConnection;
    Endpoint ed = new Endpoint();
    Encryption e = new Encryption();

    public JSONObject validateBVN(String bvn) throws Exception {
        this.apiConnection = new ApiConnection(ed.getBvnEndpoint());
        String seckey ="FLWSECK-e6db11d1f8a6208de8cb2f94e293450e-X";
   String url ="https://ravesandboxapi.flutterwave.com/v2/kyc/bvn/"+bvn+"?seckey="+seckey;
        System.out.println(url);

       
        return this.apiConnection.connectAndQueryWithGet(url);

    }

    public static URI appendUri(String uri, String appendQuery) throws URISyntaxException {
        URI oldUri = new URI(uri);

        String newQuery = oldUri.getQuery();
        if (newQuery == null) {
            newQuery = appendQuery;
        } else {
            newQuery += "&" + appendQuery;
        }

        URI newUri = new URI(oldUri.getScheme(), oldUri.getAuthority(),
                oldUri.getPath(), newQuery, oldUri.getFragment());

        return newUri;
    }

    /**
     * @return the bvn_number
     */
    public String getBvn_number() {
        return bvn_number;
    }

    /**
     * @param bvn_number the bvn_number to set
     */
    public void setBvn_number(String bvn_number) {
        this.bvn_number = bvn_number;
    }
}
