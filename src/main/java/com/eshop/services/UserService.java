package com.eshop.services;

import com.eshop.model.User;
import com.eshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    //@Autowired
    //UserRepositoryCustom userRepositoryCustom;

    public ResponseEntity register(User user) {

//        boolean hasError = false;
//        if(!userRepositoryCustom.isEmailUnique(user.getEmailId())) {
//            hasError = true;
//        }
//
//        if(!userRepositoryCustom.isUserNameUnique(user.getUsername())) {
//            hasError = true;
//        }

//        if(hasError) {
//            return new ResponseEntity(HttpStatus.CONFLICT);
//        }
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
