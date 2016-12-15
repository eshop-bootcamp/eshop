package com.eshop.model;

import java.util.ArrayList;
import java.util.List;

public class UserResponse {


    private List<String> errors = new ArrayList<>();

    public UserResponse(List<String> errors, String name) {

        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }


}
