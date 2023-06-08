package ru.netology.springbootrestdemo.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public final class User {
    @Size(min = 10, max = 30)
    @NotBlank
    private String user;
    @Size(min = 4, max = 30)
    private String password;

    public User() {
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
