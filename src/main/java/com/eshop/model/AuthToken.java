package com.eshop.model;

import org.springframework.security.core.token.Token;

/**
 * Created by akshaybansod on 12/14/16.
 */
public class AuthToken implements Token {


    @Override
    public String getKey() {
        return null;
    }

    @Override
    public long getKeyCreationTime() {
        return 0;
    }

    @Override
    public String getExtendedInformation() {
        return null;
    }
}
