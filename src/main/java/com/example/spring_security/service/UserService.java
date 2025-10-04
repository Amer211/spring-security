package com.example.spring_security.service;

import com.example.spring_security.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    List<User> findAll();
    User saveUser(User user);
    void deleteUserById(Long id);
    User updateUser(Long id, User user);
    Optional<User> findUserById(Long id);
    Optional<User> findUserByUsername(String username);
}
