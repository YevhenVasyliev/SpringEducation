package com.epam.repository.ticket;

import com.epam.entity.UserTicket;
import com.epam.repository.auditorium.SeatMapper;
import com.epam.repository.event.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yevhen_Vasyliev on 12.08.2015.
 */
@Component
public class UserTicketMapper implements RowMapper<UserTicket> {

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private SeatMapper seatMapper;

    @Override
    public UserTicket mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserTicket userTicket = new UserTicket();
        userTicket.setTicketId(rs.getLong("tickets.id"));
        userTicket.setEvent(eventMapper.mapRow(rs, rowNum));
        userTicket.setSeat(seatMapper.mapRow(rs, rowNum));
        return userTicket;
    }
}
