package ru.netology.springbootrestdemo.controller;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.netology.springbootrestdemo.model.Authorities;
import ru.netology.springbootrestdemo.model.User;
import ru.netology.springbootrestdemo.server.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {

    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Validated User user) {
        System.out.println("user: " + user.getUser()+  " password: " + user.getPassword());
        return service.getAuthorities(user);
    }

}