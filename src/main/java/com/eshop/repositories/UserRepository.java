package com.eshop.repositories;

import com.eshop.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    public abstract User findByUsername(String username);

}







