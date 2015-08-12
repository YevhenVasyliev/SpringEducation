package com.epam.service.event;

import com.epam.entity.Auditorium;
import com.epam.entity.Event;
import com.epam.repository.event.api.EventDAO;
import com.epam.service.event.api.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Yevhen_Vasyliev
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDAO eventDAO;

    @Override
    public Event create(Event event) {
        return eventDAO.add(event);
    }

    @Override
    public void assignAuditorium(Event event, Auditorium auditorium, Date date) {
        event.setAuditorium(auditorium);
        event.setStartDate(date);
        eventDAO.assignAuditorium(event);
    }
}
