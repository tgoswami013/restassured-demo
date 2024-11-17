package com.tg.demo.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ReadPayloadJSON {
    @Test
    public void readPayloadJSON() {

        LinkedHashMap<String, Object> myPet = new LinkedHashMap<String, Object>();
        LinkedHashMap<String, Object> categories = new LinkedHashMap<String, Object>();
        LinkedHashMap<String, Object> tags = new LinkedHashMap<String, Object>();
        List<LinkedHashMap<String, Object>> tagList = new ArrayList<LinkedHashMap<String, Object>>();

        myPet.put("id", 0);
        categories.put("id", 0);
        categories.put("name", "mycategory");
        myPet.put("category", categories);

        myPet.put("name", "dog123");

        List<String> photoUrls = new ArrayList<String>();
        photoUrls.add("myPhoto");

        myPet.put("photoUrls", photoUrls);

        tags.put("id", 0);
        tags.put("name", "mytag");

        tagList.add(tags);

        myPet.put("tags", tagList);


        myPet.put("status", "available");

        System.out.println(myPet);

//        String filePath = System.getProperty("user.dir") + "/src/test/resources/payload/json/pet.json";
//		File file = new File(filePath);

        Response res =
                given()
                        .baseUri("https://petstore.swagger.io/v2/pet")
                        .header("content-type","application/json")
                        .body(myPet)
//        	.log().all()
                        .when()
                        .post()
                        .then()
                        .extract().response();

        res.prettyPrint();
    }
}

