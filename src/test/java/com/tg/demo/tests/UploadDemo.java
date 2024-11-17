package com.tg.demo.tests;

import com.tg.demo.helper.Base;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UploadDemo extends Base {
    //Validate POST Request with Path and Form parameters and Upload Image
    @Test
    public void verifyAddNewPetImage() {
        File fileToUpload;
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/images/sample_image.jpg";
        System.out.println(filePath);
        fileToUpload = new File(filePath);
        Response res =
                given()
                        .header("content-type","multipart/form-data")
                        .formParam("additionalMetadata","fish")
                        .multiPart(fileToUpload )
                        .pathParam("id","10")
                        .when()
                        .post("{id}/uploadImage")
                        .then()
                        .extract().response();

        System.out.println(res.statusCode());
        System.out.println(res.headers());
        res.prettyPrint();

    }
}
