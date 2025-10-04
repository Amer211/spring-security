package com.example.spring_security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    @GetMapping("/home")
    public String home() {
        return "Welcome to the Home Page!";
    }
    @GetMapping("/dashboard")
    public String signup(HttpServletRequest session) {
        return "Welcome to the SignUp Page! Your session ID: "+
                session.getSession().getId();

    }
}
