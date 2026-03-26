package com.automation.config;

public class Config {

    // Environment
    public static final String BASE_URI = "https://petstore.swagger.io";
    public static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String API_VERSION = "v2";


    // Endpoints
    public static final String USER_ENDPOINT = "/user";
    public static final String CREATE_USER = API_VERSION + USER_ENDPOINT;
    public static final String GET_USER = API_VERSION + USER_ENDPOINT + "/{username}";
    public static final String UPDATE_USER = API_VERSION + USER_ENDPOINT + "/{username}";
    public static final String DELETE_USER = API_VERSION + USER_ENDPOINT + "/{username}";

    // Assertions
    public static final int SUCCESS_STATUS_CODE = 200;
    public static final int NOT_FOUND_STATUS_CODE = 404;
}