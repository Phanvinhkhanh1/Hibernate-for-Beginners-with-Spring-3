package com.selfStudy.SpringHibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/funController")
    public String getName() {
        return "hello World!";
    }

    @GetMapping("/secondController")
    public String getInfo() {
        return "Phan Vinh Khanh";
    }
}
