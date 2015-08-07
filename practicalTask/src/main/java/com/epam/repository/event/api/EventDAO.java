package com.epam.repository.event.api;

import com.epam.entity.Auditorium;
import com.epam.entity.Event;

import java.util.Date;

/**
 * Created by Yevhen_Vasyliev on 07.08.2015.
 */
public interface EventDAO {

    boolean add(Event event);

    void assignAuditorium(Event event, Auditorium auditorium, Date date);

    Event getById(long eventId);
}
