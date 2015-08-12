package com.epam.service.event.api;

import com.epam.entity.Auditorium;
import com.epam.entity.Event;

import java.util.Date;

/**
 * @author Yevhen_Vasyliev
 */
public interface EventService {

    Event create(Event event);

    void assignAuditorium(Event event, Auditorium auditorium, Date date);

}
