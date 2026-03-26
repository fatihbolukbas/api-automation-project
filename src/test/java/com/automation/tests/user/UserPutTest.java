package com.automation.tests.user;

import com.automation.config.Config;
import com.automation.payloads.user.PostUserPayload;
import com.automation.utils.user.TestDataUserPut;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserPutTest extends BaseUserTest {

    @BeforeClass
    public void setUpData() {
        createUser();
    }

    @Test
    public void shouldUpdateUser() {

        int putId = TestDataUserPut.id();
        String putUsername = TestDataUserPut.username();
        String putFirstName = TestDataUserPut.firstname();
        String putLastName = TestDataUserPut.lastname();
        String putEmail = TestDataUserPut.email();
        String putPassword = TestDataUserPut.password();
        String putPhone = TestDataUserPut.phone();
        int putUserStatus = TestDataUserPut.userStatus();

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
    }
}
