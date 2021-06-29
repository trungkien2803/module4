package com.codegym.service;

import com.codegym.model.User;

import java.util.Optional;

public interface IUserService {
    Iterable<User> findAll();

    Optional<User> findById(Long id);

    User sava (User user);

    void deleteById(Long id);


}
