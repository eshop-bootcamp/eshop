package com.eshop.auth;

import com.eshop.EShopApplication;
import com.jayway.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.SpringApplication;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AuthenticationTest {

    @BeforeClass
    public static void setUp() {
        SpringApplication.run(EShopApplication.class, "");
    }

    @Test
    public void shouldNotAllowAccessWithoutLogin() {
        given().port(8443).get("/")
                .then().
                statusCode(401);
    }

    @Test
    public void shouldAuthenticateUserWithBasicAuthGivenProperCredentials() {
        String response = given()
                .auth().preemptive()
                .basic("username", "password")
//                .header("Authorization", "Basic dXNlcjpwYXNzd29yZA==")
                .get("/")
                .then()
                .extract()
                .response().body().prettyPrint();
        assertThat(response, is("Hello World !"));
    }

    @Test
    public void shouldAuthenticateUserWithBasicAuthGivenIncorrectCredentials() {
        given().auth().preemptive()
                .basic("", "")
                .get("/")
                .then()
                .statusCode(401);
    }

}
