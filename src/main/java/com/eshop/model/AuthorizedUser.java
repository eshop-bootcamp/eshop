package com.eshop.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class AuthorizedUser {
    private final String token;
    private final Map<String, String> userDetails;

    @Override
    public String toString() {
        return "AuthorizedUser{" +
                "token='" + token + '\'' +
                ", userDetails=" + userDetails +
                '}';
    }

    public AuthorizedUser(String token, User validUser) {
        this.token = token;
        userDetails = new LinkedHashMap<>();
        userDetails.put("username", validUser.getUsername());
        userDetails.put("role", validUser.getUserType());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorizedUser that = (AuthorizedUser) o;

        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        return userDetails != null ? userDetails.equals(that.userDetails) : that.userDetails == null;

    }

    @Override
    public int hashCode() {
        int result = token != null ? token.hashCode() : 0;
        result = 31 * result + (userDetails != null ? userDetails.hashCode() : 0);
        return result;
    }

    public String getToken() {
        return token;
    }

    public Map<String, String> getUserDetails() {
        return userDetails;
    }
}
