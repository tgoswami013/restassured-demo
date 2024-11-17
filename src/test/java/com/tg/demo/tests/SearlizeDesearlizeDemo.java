package com.tg.demo.tests;

import com.tg.demo.helper.Base;
import com.tg.demo.pojo.Category;
import com.tg.demo.pojo.Pet;
import com.tg.demo.pojo.Tag;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SearlizeDesearlizeDemo extends Base {
    Pet petObj = new Pet();
    Category categoryObj  = new Category(15L, "Tarun");
    List<Tag> tagObjLst = new ArrayList<Tag>();

    @Test
    public void myDeserialize(){
        Pet[] petObj =
                given()
                    .spec(requestSpec)
                    .queryParam("status", "sold")
                    .when()
                    .get("findByStatus").as(Pet[].class);

        System.out.println(petObj[1].getId());
        System.out.println(petObj[1].getName());
    }

    @Test
    public void verifyAddNewPet() {
        petObj.setId(2L);
        petObj.setCategory(categoryObj);

        tagObjLst.add(new Tag(7, "random"));
        petObj.setTags(tagObjLst);

        ArrayList<String> photoLst = new ArrayList<>();
        photoLst.add("abc");
        petObj.setPhotoUrls(photoLst);

        petObj.setStatus("available");

        Response res =
                given()
                        .spec(requestSpec)
                        .header("content-type","application/json")
                        .body(petObj)
                        .when()
                        .post()
                        .then()
                        .extract().response();

        System.out.println(res.statusCode());
        res.prettyPrint();
    }
}
