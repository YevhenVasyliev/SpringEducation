package com.epam.service.booking.api;

import com.epam.entity.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Yevhen_Vasyliev
 */
public interface BookingService {

    /**
     * Returns price for ticket for specified event on specific date and time for specified seats.
     */
    Map<UserTicket, Double> getTicketPrice(Event event, Date date, List<Seat> seats, User user);

    /**
     * Get all purchased tickets for event for specific date
     * @param date - date of event
     * @return
     */
    List<Ticket> getTicketsForEvent(Event event, Date date);

    Ticket bookTicket(Ticket ticket);

    List<Ticket> getBookedTickets();

    List<UserTicket> getAllBookedTicketByUser(User user);
}
