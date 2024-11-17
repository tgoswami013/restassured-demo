package com.tg.demo.tests;

import com.tg.demo.helper.Base;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemaDemo extends Base {
    @Test
    //Validate the JSON Schema
    public void verifyjsonSchema() {

        given()
                .spec(requestSpec)
                .queryParam("status", "sold")
                .when()
                .get("findByStatus")
                .then()
                .body(matchesJsonSchemaInClasspath("schema/pet/find-by-status.json"));

    }
}
