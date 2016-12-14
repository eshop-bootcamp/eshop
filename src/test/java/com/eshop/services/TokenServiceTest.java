package com.eshop.services;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class TokenServiceTest {

    @Test
    public void shouldAllocateTokenStringForGivenData() {
        TokenService tokenService = new TokenService();

        String data = "RandomData";
        String actual = tokenService.allocateToken(data);
        String expected = "RandomData-UmFuZG9tRGF0YTpEbyBub3QgZXZlbiB0cnkgdG8gaGFjayBtZQ==";

        assertThat(actual, is(expected));
    }

    @Test
    public void verifyToken() throws Exception {
        TokenService tokenService = new TokenService();
        String token = "RandomData-UmFuZG9tRGF0YTpEbyBub3QgZXZlbiB0cnkgdG8gaGFjayBtZQ==";

        assertTrue(tokenService.verifyToken(token));
    }

}