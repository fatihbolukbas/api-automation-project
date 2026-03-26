package com.automation.utils.user;

public class TestDataUserPut {

    private static final String UNIQUE_USERNAME = "fbolukbas" + System.currentTimeMillis();

    public static int id(){
        return 5;
    }

    public static String  username() {
        return UNIQUE_USERNAME;
    }

    public static String firstname() {
        return "Fatih";
    }

    public static String lastname() {
        return "Bolukbas";
    }

    public static String email() {
        return "fbolukbas@yopmail.com";
    }

    public static String password() {
        return "123456";
    }

    public static String phone() {
        return "5419999999";
    }

    public static int userStatus() {
        return 1;
    }
}
