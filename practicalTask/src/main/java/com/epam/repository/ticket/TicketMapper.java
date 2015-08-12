package com.epam.repository.ticket;

import com.epam.entity.Ticket;
import com.epam.repository.auditorium.SeatMapper;
import com.epam.repository.user.UserMapper;
import com.epam.repository.util.InsertQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yevhen_Vasyliev on 12.08.2015.
 */
@Component
public class TicketMapper implements RowMapper<Ticket>, InsertQueryMapper<Ticket> {

    @Autowired
    private SeatMapper seatMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setId(rs.getLong("tickets.id"));
        ticket.setIdEvent(rs.getLong("tickets.event_Id"));
        ticket.setDate(rs.getDate("tickets.event_date"));
        ticket.setSeat(seatMapper.mapRow(rs, rowNum));
        ticket.setUser(userMapper.mapRow(rs, rowNum));
        return ticket;
    }

    @Override
    public void mapForInsert(Ticket entity, PreparedStatement ps) throws SQLException {
        ps.setLong(1, entity.getIdEvent());
        ps.setLong(2, entity.getUser().getId());
        ps.setLong(3, entity.getSeat().getId());
        ps.setDate(4, new Date(entity.getDate().getTime()));
    }
}
