package com.springhibernate.restcrud.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class SpringRestController {

    @GetMapping("/hello")
    public String getInfo() {
        return "Hello World!";
    }
}
