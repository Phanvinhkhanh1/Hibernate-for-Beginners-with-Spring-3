package com.selfStudy.SpringHibernate.controller;

import com.selfStudy.SpringHibernate.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private Coach theCoach;

    @Autowired
    public RestController(@Qualifier("cricketCoach") Coach theCoach) {
        System.out.println("In constructor : " + getClass().getSimpleName());
        this.theCoach = theCoach;
    }

    @GetMapping("/info")
    public String getInfo() {
        return theCoach.getDailyWorkout();
    }
}
