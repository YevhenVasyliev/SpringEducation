package com.epam.service.counter;

import com.epam.repository.counter.api.CounterForEventsDAO;
import com.epam.service.counter.api.CounterForEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Yevhen_Vasyliev on 07.08.2015.
 */
@Service
public class CounterForEventsServiceImpl implements CounterForEventsService {

    @Autowired
    private CounterForEventsDAO counterForEventsDAO;
    @Override
    public void increment() {
        counterForEventsDAO.incrementCounter();
    }
}
