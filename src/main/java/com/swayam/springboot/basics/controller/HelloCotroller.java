package com.swayam.springboot.basics.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCotroller {
    @Value("$user.welcome.message")
    private String welcomeMsg;
    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String hello() {
        return welcomeMsg;
    }
}
