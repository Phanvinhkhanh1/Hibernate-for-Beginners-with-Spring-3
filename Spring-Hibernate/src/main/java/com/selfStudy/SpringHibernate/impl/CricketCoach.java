package com.selfStudy.SpringHibernate.impl;

import com.selfStudy.SpringHibernate.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Learn Chinese and English everyday";
    }
}
