package com.automation.tests.user;

import com.automation.config.Config;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserGetTest extends BaseUserTest {

    @BeforeClass
    public void setUpData() {
        createUser();
    }

    @Test
    public void shouldGetUserByUsername() {

        String postUsername = BaseUserTest.createdUsername();

        given()
                .log().all()
                .when()
                .get(Config.GET_USER, postUsername)
                .then()
                .log().all()
                .assertThat()
                .statusCode(Config.SUCCESS_STATUS_CODE)
                .body("username", equalTo(postUsername));
    }
}
