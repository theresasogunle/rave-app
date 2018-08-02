# rave-app
[![Coverage Status](https://coveralls.io/repos/github/theresasogunle/rave-backend/badge.svg?branch=master)](https://coveralls.io/github/theresasogunle/rave-backend?branch=master)

## Test Implementation

<a href="https://ravemovies.herokuapp.com" target="_blank" style="margin-right: 15px"><img src="http://imglibv3.successbyemail.com/ImgLib/a564641c-6f39-409b-8c1e-6e006b13b9b2/ViewNowButton.png" width="250px"></a>
<a href="https://github.com/theresasogunle/movie-app" target="_blank" style="margin-right: 15px"><img src="https://www.aha.io/assets/github.7433692cabbfa132f34adb034e7909fa.png" width="250px"></a>

# Getting Started

> Signup for a test account [here](http://rave.frontendpwc.com/)

> Signup for a live account [here](https://rave.flutterwave.com)
### Maven

```bash
<dependency>
  <groupId>com.rave</groupId>
  <artifactId>rave</artifactId>
  <version>1.0.1</version>
  <type>jar</type>
</dependency>
```

## Sample Use
```java
        RaveConstant.PUBLIC_KEY = "FLWPUBK-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-X";
        RaveConstant.SECRET_KEY = "FLWSECK-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;

        CardCharge ch = new CardCharge();
        ch.setCardno("4556052704172643")
                .setCvv("899")
                .setCurrency("NGN")
                .setCountry("NG")
                .setAmount("9000")
                .setExpiryyear("19")
                .setExpirymonth("01")
                .setEmail("sogunledolapo@gmail.com")
                .setTxRef("MXX-ASC-4578")
                .setRedirect_url("https://ravemovies.herokuapp.com/verify");

        JSONObject charge = ch.chargeCard();
        
```

## Classes 
1. AccountCharge
2. CardCharge
3. Transfer
4. QRCharge
5. RecurringPayment 
6. SubAccount
7. BvnValidation
