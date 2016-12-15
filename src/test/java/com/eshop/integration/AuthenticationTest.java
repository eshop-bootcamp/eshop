package com.eshop.integration;

import com.eshop.EShopApplication;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Header;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;

import static com.jayway.restassured.RestAssured.given;


public class AuthenticationTest {

    @BeforeClass
    public static void setUp() {
        SpringApplication.run(EShopApplication.class, "");
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://localhost:8443";
    }

    @Test
    public void shouldNotAllowAccessWithoutLogin() {
        given()
                .get("/category/getcategories")
                .then()
                .statusCode(HttpStatus.UNAUTHORIZED.value());
    }

    @Test
    public void shouldGetOkResponseForGivenProperCredentials() {
        given()
                .body("{\"username\":\"john\", \"password\":\"pass123\" }")
                .header(new Header("content-type", "application/json"))
                .post("/login")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void shouldSendUnautherizedResponseGivenIncorrectCredentials() {
        given()
                .body("{\"username\":\"johnny\", \"password\":\"pass123\" }")
                .header(new Header("content-type", "application/json"))
                .post("/login")
                .then()
                .statusCode(HttpStatus.UNAUTHORIZED.value());
    }

    @Test
    public void shouldSendUnautherizedResponseWhenGivenNullCredential() {
        given()
                .body("")
                .header(new Header("content-type", "application/json"))
                .post("/login")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void shouldSendUnautherizedResponseWithCorrectUserButIncorrectPassword() {
        given()
                .body("{\"username\":\"john\", \"password\":\"pass1231\" }")
                .header(new Header("content-type", "application/json"))
                .post("/login")
                .then()
                .statusCode(HttpStatus.UNAUTHORIZED.value());
    }

}
