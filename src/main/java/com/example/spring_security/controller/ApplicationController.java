package com.example.spring_security.controller;

import com.example.spring_security.entity.User;
import com.example.spring_security.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    private final UserService userService;
    public ApplicationController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/home")
    public String home() {
        return "Welcome to the Home Page!";
    }
    @GetMapping("/dashboard")
    public String signup(HttpServletRequest session) {
        return "Welcome to the SignUp Page! Your session ID: "+
                session.getSession().getId();
    }
    @PostMapping("/save")
    public String save(@RequestBody User user) {
        userService.saveUser(user);
        return user.getUsername()+" saved successfully!";
    }
}
