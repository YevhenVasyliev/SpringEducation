package com.epam.repository.counter;

import com.epam.repository.counter.api.CounterForEventsDAO;
import org.springframework.stereotype.Repository;

/**
 * Created by Yevhen_Vasyliev on 07.08.2015.
 */
@Repository
public class CounterForEventsDAOImpl implements CounterForEventsDAO {

    private long counter;

    public CounterForEventsDAOImpl() {
    }

    @Override
    public void incrementCounter() {
        counter++;
    }
}
