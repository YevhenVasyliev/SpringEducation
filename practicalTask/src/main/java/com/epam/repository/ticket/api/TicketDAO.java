package com.epam.repository.ticket.api;

import com.epam.entity.*;

import java.util.List;

/**
 * @author Yevhen_Vasyliev
 */
public interface TicketDAO {

    List<Ticket> getAllTicket();

    List<UserTicket> getTicketsByDateAndUserAndSeats(Event event, List<Seat> seats, User user);

    Ticket add(Ticket ticket);

    List<UserTicket> getAllBookedTicketByUser(long userId);

}
