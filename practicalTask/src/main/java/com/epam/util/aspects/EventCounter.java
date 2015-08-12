package com.epam.util.aspects;

import com.epam.service.counter.api.CounterForEventsService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Yevhen_Vasyliev on 07.08.2015.
 */
@Aspect
@Component
public class EventCounter {

    @Autowired
    private CounterForEventsService counterForEventsService;

    @Before("execution(* com.epam.repository.event.EventDAOImpl.add(*))")
    private void countAddedEvents() {
        counterForEventsService.increment();
        System.out.println("Event was added.");
    }


}
