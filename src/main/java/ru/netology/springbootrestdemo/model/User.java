package ru.netology.springbootrestdemo.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record User(@Size(min = 4, max = 25) @NotBlank String user, @Size(min = 4, max = 25)  @NotBlank String password){

}
