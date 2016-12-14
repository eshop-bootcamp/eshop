package com.eshop.integration;

import com.eshop.EShopApplication;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class AuthenticationTest {

    @BeforeClass
    public static void setUp() {
        SpringApplication.run(EShopApplication.class, "");
    }

    @Test @Ignore
    public void shouldNotAllowAccessWithoutLogin() {
        given().
                port(8443).get("/category/getcategories")
                .then().
                statusCode(401);
    }

    @Test @Ignore
    public void shouldAuthenticateUserWithBasicAuthGivenProperCredentials() {
        String response = given()
                .port(8443)
                .auth().preemptive()
                .basic("username", "password")
                .get("/user")
                .then()
                .extract()
                .response().body().prettyPrint();
        assertThat(response, is("Authenticated!"));
    }

    @Test @Ignore
    public void shouldAuthenticateUserWithBasicAuthGivenIncorrectCredentials() {
        given().port(8443)
                .auth().preemptive()
                .basic("", "")
                .get("/")
                .then()
                .statusCode(401);
    }

}
