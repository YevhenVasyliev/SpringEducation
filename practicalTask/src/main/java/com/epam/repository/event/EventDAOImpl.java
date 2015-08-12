package com.epam.repository.event;

import com.epam.entity.Event;
import com.epam.repository.event.api.EventDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static com.epam.repository.event.EventSQLQuery.*;

import java.util.List;

/**
 * Created by Yevhen_Vasyliev on 07.08.2015.
 */
@Repository
public class EventDAOImpl implements EventDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EventMapper eventMapper;

    public EventDAOImpl() {
    }

    @Override
    public Event add(Event event) {
        int eventId = jdbcTemplate.update(ADD_EVENT, eventMapper, event);
        event.setId(eventId);
        return event;
    }

    @Override
    public void assignAuditorium(Event event) {
        Object[] args = {event.getAuditorium().getId(), event.getId()};
        jdbcTemplate.update(UPDATE_EVENT_AUDITORIUM, args);
    }

    @Override
    public Event getById(long eventId) {
        return jdbcTemplate.queryForObject(GET_EVENT_BY_ID, eventMapper, eventId);
    }
}
