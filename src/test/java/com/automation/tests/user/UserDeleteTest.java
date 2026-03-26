package com.automation.tests.user;

import com.automation.config.Config;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class UserDeleteTest extends BaseUserTest {

    @BeforeClass
    public void setUpData() {
        createUser();
    }

    @Test
    public void shouldDeleteUser() {
        String username = BaseUserTest.createdUsername();

        given()
                .log().all()
                .when()
                .delete(Config.DELETE_USER, username)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("code", equalTo(Config.SUCCESS_STATUS_CODE));
    }
}
