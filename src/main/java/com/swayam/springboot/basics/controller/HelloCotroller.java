package com.swayam.springboot.basics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCotroller {
    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String hello() {
        return "Welcome to Spring Boot!!";
    }
}
