package com.tg.demo.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ReadPayloadJSONDemo {
    @Test
    public void readPayloadJSON() {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/payload/json/pet.json";
        File file = new File(filePath);

        Response res =
                given()
                        .baseUri("https://petstore.swagger.io/v2/pet")
                        .header("content-type","application/json")
                        .body(file)
                        .when()
                        .post()
                        .then()
                        .extract().response();

        res.prettyPrint();
    }
}
