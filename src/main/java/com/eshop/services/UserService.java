package com.eshop.services;

import com.eshop.model.User;
import com.eshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity register(User user) {
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public User validateUser(User userToValidate) {
        User user = userRepository.findByUsername(userToValidate.getUsername());
        if (user == null || !user.getPassword().equals(userToValidate.getPassword())) {
            throw new UsernameNotFoundException("Username not found" + userToValidate.getUsername());
        }
        return user;

    }
}
