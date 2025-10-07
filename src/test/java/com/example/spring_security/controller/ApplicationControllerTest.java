package com.example.spring_security.controller;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;
@RestController
class ControllerTest {

    @GetMapping("/test")
    public String test(@AuthenticationPrincipal UserDetails user) {
        return "Hello,you're logged in as :" + user.getUsername() +
                " with roles : " + user.getAuthorities().toString();
    }

    @Test
    void signup() {
    }
}