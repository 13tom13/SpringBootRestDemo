package ru.netology.springbootrestdemo.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springbootrestdemo.model.Authorities;
import ru.netology.springbootrestdemo.model.User;
import ru.netology.springbootrestdemo.server.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorizationController {

    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        System.out.println("user: " + user.user() + " password: " + user.password());
        return service.getAuthorities(user);
    }

    @GetMapping("/test")
    public String test(@Value("${server.port}") String port) {
        System.out.println("test");
        return String.format("server port is %s", port);
    }
}