package com.selfStudy.SpringHibernate.impl;

import com.selfStudy.SpringHibernate.Coach;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Learn Chinese and English everyday";
    }
}
