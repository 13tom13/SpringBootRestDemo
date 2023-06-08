package ru.netology.springbootrestdemo.controller;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.netology.springbootrestdemo.model.Authorities;
import ru.netology.springbootrestdemo.model.Person;
import ru.netology.springbootrestdemo.model.User;
import ru.netology.springbootrestdemo.server.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class AuthorizationController {

    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @PostMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestBody @Validated User user) {
        System.out.println("user: " + user.getUser()+  " password: " + user.getPassword());
        return service.getAuthorities(user);
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @PostMapping("/person")//тест валидации
    public String hello(@RequestBody @Validated Person person) {
        return String.format("name %s age %s", person.getName(), person.getAge());
    }



}