package com.automation.tests.user;

import com.automation.config.Config;
import com.automation.payloads.user.PostUserPayload;
import com.automation.utils.user.TestDataUserPost;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class BaseUserTest {

    public static String createdUsername;

    protected static String createdUsername() {
        return createdUsername;
    }

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = Config.BASE_URI();
    }

    public void createUser() {

        int postId = TestDataUserPost.id();
        String postUsername = TestDataUserPost.username();
        String postFirstname = TestDataUserPost.firstname();
        String postLastname = TestDataUserPost.lastname();
        String postEmail = TestDataUserPost.email();
        String postPassword = TestDataUserPost.password();
        String postPhone = TestDataUserPost.phone();
        int postUserStatus = TestDataUserPost.userStatus();

        given()
                .log().all()
                .header(Config.CONTENT_TYPE_HEADER(), Config.CONTENT_TYPE_JSON())
                .body(PostUserPayload.getRegisterPayload(postId,
                        postUsername,
                        postFirstname,
                        postLastname,
                        postEmail,
                        postPassword,
                        postPhone,
                        postUserStatus))
                .when()
                .post(Config.CREATE_USER())
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("code", equalTo(Config.SUCCESS_STATUS_CODE()));

        createdUsername = postUsername;
    }
}
