package com.iris.test.steps;

import com.iris.test.utils.GetInfo;
import com.iris.test.utils.WriteTest;


import io.cucumber.java.en.*;
import io.restassured.response.Response;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import org.junit.BeforeClass;

public class GetStatisticsSteps {

  private static Response response;
  private static String expected;


  @Given("Rober wanna know the statistics abouts {string}")
  public static void rober_wanna_know_the_statistics_abouts_countries(String country)
      throws IOException {
    WriteTest.createFile(country);
    expected = country;
  }

  @When("Rober get the failed response")
  public static void getFailedResponse(){
    response = GetInfo.forCountry("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/total?country="+expected
        , false);

    System.out.println();
  }

  @When("Rober get the response")
  public static void getTheResponse() throws IOException {
    response = GetInfo.forCountry("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/total?country="+expected
        , true);

    WriteTest.the("*********************************"+expected+"*************************************\n");
    WriteTest.the("********************************* Body ************************************\n");
    WriteTest.the(response.getBody().print());
    WriteTest.the("'n");
    Serenity.recordReportData().withTitle("Body").andContents(response.getBody().print());
    String actual = response.then().extract().path("data.location");
    Assert.assertEquals("Validation of the correct country search",expected, actual);

  }

  @Then("Rober can not get information")
  public static void canNotGetInformation(){

    String expected = "Invalid API key. Go to https://docs.rapidapi.com/docs/keys for more info.";
    String actual = response.then().extract().path("message");
    Assert.assertEquals("Validation of the correct country search",expected, actual);


  }

  @Then("Rober validate the information")
  public static void validateTheInformation() throws IOException {
    WriteTest.the("\n");
    WriteTest.the("********************************* Headers ************************************\n");
    WriteTest.the(response.getHeaders().toString());
    WriteTest.the("'n");
    Serenity.recordReportData().withTitle("Headers").andContents(response.getHeaders().toString());
  }

}
