package com.automation.tests.user;

import com.automation.config.Config;
import com.automation.payloads.user.PostUserPayload;
import com.automation.utils.user.TestDataUserPost;
import com.automation.utils.user.TestDataUserPut;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class CRUDFlowTest {

    @Test
    public void shouldRunCrudFlow() {

        RestAssured.baseURI = Config.BASE_URI;

        int postId = TestDataUserPost.id();
        String postUsername = TestDataUserPost.username();
        String postFirstname = TestDataUserPost.firstname();
        String postLastname = TestDataUserPost.lastname();
        String postEmail = TestDataUserPost.email();
        String postPassword = TestDataUserPost.password();
        String postPhone = TestDataUserPost.phone();
        int postUserStatus = TestDataUserPost.userStatus();

        int putId = TestDataUserPut.id();
        String putUsername = TestDataUserPut.username();
        String putFirstName = TestDataUserPut.firstname();
        String putLastName = TestDataUserPut.lastname();
        String putEmail = TestDataUserPut.email();
        String putPassword = TestDataUserPut.password();
        String putPhone = TestDataUserPut.phone();
        int putUserStatus = TestDataUserPut.userStatus();

        //Create User
            given()
                    .log().all()
                    .header(Config.CONTENT_TYPE_HEADER, Config.CONTENT_TYPE_JSON)
                    .body(PostUserPayload.getRegisterPayload(postId,
                            postUsername,
                            postFirstname,
                            postLastname,
                            postEmail,
                            postPassword,
                            postPhone,
                            postUserStatus))
                    .when()
                    .post(Config.CREATE_USER)
                    .then()
                    .log().all()
                    .assertThat()
                    .statusCode(Config.SUCCESS_STATUS_CODE)
                    .body("code", equalTo(Config.SUCCESS_STATUS_CODE));

        //Read User
            given()
                    .log().all()
                    .when()
                    .get(Config.GET_USER, postUsername)
                    .then()
                    .log().all()
                    .assertThat()
                    .statusCode(Config.SUCCESS_STATUS_CODE)
                    .body("username", equalTo(postUsername));

        //Update User
            given()
                    .log().all()
                    .header(Config.CONTENT_TYPE_HEADER, Config.CONTENT_TYPE_JSON)
                    .body(PostUserPayload.getRegisterPayload(putId,
                            putUsername,
                            putFirstName,
                            putLastName,
                            putEmail,
                            putPassword,
                            putPhone,
                            putUserStatus
                    ))
                    .when()
                    .put(Config.UPDATE_USER, putUsername)
                    .then()
                    .log().all()
                    .assertThat()
                    .statusCode(Config.SUCCESS_STATUS_CODE)
                    .body("code", equalTo(Config.SUCCESS_STATUS_CODE));

        //Read User
        given()
                .log().all()
                .when()
                .get(Config.GET_USER, putUsername)
                .then()
                .log().all()
                .assertThat()
                .statusCode(Config.SUCCESS_STATUS_CODE)
                .body("phone", equalTo(putPhone));

        //Delete User
        given()
                .log().all()
                .when()
                .delete(Config.DELETE_USER, putUsername)
                .then()
                .log().all()
                .assertThat()
                .statusCode(Config.SUCCESS_STATUS_CODE)
                .body("code", equalTo(Config.SUCCESS_STATUS_CODE));

        //Read User
        try {
            given()
                    .log().all()
                    .when()
                    .get(Config.GET_USER, putUsername)
                    .then()
                    .log().all()
                    .assertThat()
                    .statusCode(Config.NOT_FOUND_STATUS_CODE)
                    .body("message", equalTo("User not found"));
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().contains("404"), "Beklenen durum: delete sonrasi 404");
        }
    }
}
