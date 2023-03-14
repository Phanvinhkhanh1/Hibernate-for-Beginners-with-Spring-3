package com.selfStudy.SpringHibernate.controller;

import com.selfStudy.SpringHibernate.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private Coach theCoach;

    @GetMapping("/info")
    public String getInfo() {
        return theCoach.getDailyWorkout();
    }
}
