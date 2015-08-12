package com.epam.repository.ticket;

import com.epam.entity.*;
import com.epam.repository.ticket.api.TicketDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.epam.repository.ticket.TicketSQLQuery.*;

/**
 * @author Yevhen_Vasyliev
 */
@Repository
public class TicketDAOImpl implements TicketDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private UserTicketMapper userTicketMapper;

    @Override
    public List<Ticket> getAllTicket() {
        return jdbcTemplate.query(GET_ALL_TICKET, ticketMapper);
    }

    @Override
    public List<UserTicket> getTicketsByDateAndUserAndSeats(Event event, List<Seat> seats, User user) {
        List<UserTicket> userTickets = new ArrayList<>();
        for (Seat seat : seats) {
            Object[] args = {event.getId(), user.getId(), event.getStartDate(), seat.getId()};
            userTickets.addAll(jdbcTemplate.query(GET_TICKET_BY_EVENT_SEAT_USER, userTicketMapper, args));
        }
        return userTickets;
    }

    @Override
    public Ticket add(Ticket ticket) {
        int ticketId = jdbcTemplate.update(ADD_TICKET, ticketMapper, ticket);
        ticket.setId(ticketId);
        return ticket;
    }

    @Override
    public List<UserTicket> getAllBookedTicketByUser(long userId) {
        return jdbcTemplate.query(GET_TICKET_BY_USER, userTicketMapper, userId);
    }

}
