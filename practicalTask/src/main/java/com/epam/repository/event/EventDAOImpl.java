package com.epam.repository.event;

import com.epam.entity.Auditorium;
import com.epam.entity.Event;
import com.epam.repository.event.api.EventDAO;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Yevhen_Vasyliev on 07.08.2015.
 */
@Repository
public class EventDAOImpl implements EventDAO {

    private List<Event> events;

    public EventDAOImpl() {
    }

    public EventDAOImpl(List<Event> events) {
        this.events = events;
    }

    @Override
    public boolean add(Event event) {
        return events.add(event);
    }

    @Override
    public void assignAuditorium(Event event, Auditorium auditorium, Date date) {
        Event requiredEvent = getById(event.getId());
        if (requiredEvent != null) {
            requiredEvent.setAuditorium(auditorium);
            requiredEvent.setStartDate(date);
        }
    }

    @Override
    public Event getById(long eventId) {
        for (Event event : events) {
            if (event.getId() == eventId) {
                return event;
            }
        }
        return null;
    }
}
