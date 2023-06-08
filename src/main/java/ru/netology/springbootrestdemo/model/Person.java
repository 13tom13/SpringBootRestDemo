package ru.netology.springbootrestdemo.model;

import lombok.Data;

import javax.validation.constraints.*;


@Data
public class Person {
    @Size(min =5, max = 20)
    @NotBlank
    private String name;
    @Min(7)
    @Max(21)
    private int age;
}
