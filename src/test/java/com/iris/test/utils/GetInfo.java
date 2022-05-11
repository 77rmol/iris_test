package com.iris.test.utils;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetInfo {

  @Step
  public static Response forCountry(String url, boolean correct){

    Response response;

    if (correct){
      response = SerenityRest.given()
          .header("X-RapidAPI-Host","covid-19-coronavirus-statistics.p.rapidapi.com")
          .header("X-RapidAPI-Key","d30d77bb95mshdb4af3149051b1bp1a1b2djsn9ae149a5c727")
          .get(url);
    }else{
      response = SerenityRest.given()
          .header("X-RapidAPI-Host","covid-19-coronavirus-statistics.p.rapidapi.com")
          .get(url);
    }

    return response;
  }

}
