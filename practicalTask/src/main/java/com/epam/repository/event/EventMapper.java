package com.epam.repository.event;

import com.epam.entity.Auditorium;
import com.epam.entity.Event;
import com.epam.entity.Rating;
import com.epam.repository.auditorium.AuditoriumMapper;
import com.epam.repository.util.InsertQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yevhen_Vasyliev on 11.08.2015.
 */
@Component
public class EventMapper implements RowMapper<Event>, InsertQueryMapper<Event> {

    @Autowired
    private AuditoriumMapper auditoriumMapper;

    @Override
    public void mapForInsert(Event event, PreparedStatement ps) throws SQLException {
        ps.setString(1, event.getName());
        Date date = new Date(event.getStartDate().getTime());
        ps.setDate(2, date);
        ps.setDouble(3, event.getPrice());
        ps.setDouble(4, event.getPriceVip());
        ps.setObject(5, event.getRating());
        ps.setLong(6, event.getAuditorium().getId());
    }

    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        Event event = new Event();
        event.setId(rs.getLong("event.id"));
        event.setName(rs.getString("event.name"));
        event.setStartDate(rs.getDate("event.start_date"));
        event.setPrice(rs.getDouble("event.price"));
        event.setPriceVip(rs.getDouble("event.price_vip"));
        event.setRating(Rating.valueOf(rs.getString("event.rating")));
        event.setAuditorium(auditoriumMapper.extractData(rs).get(0));
        return event;
    }
}
