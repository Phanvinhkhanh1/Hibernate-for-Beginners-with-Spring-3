package com.selfStudy.SpringHibernate.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${user.firstname}")
    private String firstName;

    @Value("${user.lastname}")
    private String lastName;

    @GetMapping("/funController")
    public String getName() {
        return "hello World!";
    }

    @GetMapping("/secondController")
    public String getInfo() {
        return "Phan Vinh Khanh";
    }

    @GetMapping("/userInfo")
    public String getUserInfo() {
        return firstName + " " + lastName;
    }
}
