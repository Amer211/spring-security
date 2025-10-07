package com.example.spring_security.controller;

import com.example.spring_security.entity.User;
import com.example.spring_security.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    @GetMapping("/dashboard")                          // or CustomUserDetails user
    public String signup(HttpServletRequest request, @AuthenticationPrincipal(expression = "user") User user) {
        return "Welcome to the Dashboard Page, "+user.getUsername()+
                "! Your session ID:" +request.getSession().getId();
    }
    @PostMapping("/save")
    public String save(@RequestBody User user) {
        userService.saveUser(user);
        return user.getUsername()+" saved successfully!";
    }
}
