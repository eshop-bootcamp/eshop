package com.eshop.services;

import com.eshop.services.implementation.TokenServiceImpl;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class TokenServiceImplTest {

    @Test
    public void shouldAllocateTokenStringForGivenData() {
        TokenServiceImpl tokenService = new TokenServiceImpl();

        String data = "RandomData";
        String actual = tokenService.allocateToken(data);
        String expected = "RandomData-UmFuZG9tRGF0YTpEbyBub3QgZXZlbiB0cnkgdG8gaGFjayBtZQ==";

        assertThat(actual, is(expected));
    }

    @Test
    public void verifyToken() throws Exception {
        TokenServiceImpl tokenService = new TokenServiceImpl();
        String token = "RandomData-UmFuZG9tRGF0YTpEbyBub3QgZXZlbiB0cnkgdG8gaGFjayBtZQ==";

        assertTrue(tokenService.verifyToken(token));
    }

}