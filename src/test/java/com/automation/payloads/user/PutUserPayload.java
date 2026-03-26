package com.automation.payloads.user;

public class PutUserPayload {

    public static String getUpdatePayload(int id,
                                          String username,
                                          String firstname,
                                          String lastname,
                                          String email,
                                          String password,
                                          String phone,
                                          int userStatus) {

        return "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"username\": \"" + username + "\",\n" +
                "  \"firstName\": \"" + firstname + "\",\n" +
                "  \"lastName\": \"" + lastname + "\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"" + password + "\",\n" +
                "  \"phone\": \"" + phone + "\",\n" +
                "  \"userStatus\": " + userStatus + "\n" +
                "}";
    }
}
