package com.epam.repository.event.api;

import com.epam.entity.Auditorium;
import com.epam.entity.Event;

import java.util.Date;

/**
 * Created by Yevhen_Vasyliev on 07.08.2015.
 */
public interface EventDAO {

    Event add(Event event);

    void assignAuditorium(Event event);

    Event getById(long eventId);
}
