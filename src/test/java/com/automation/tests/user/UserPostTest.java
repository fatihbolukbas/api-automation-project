package com.automation.tests.user;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserPostTest extends BaseUserTest {

    @Test
    public void shouldCreateUser() {
        createUser();
    }
}
