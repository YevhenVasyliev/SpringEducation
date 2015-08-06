package com.epam.service.booking.api;

import com.epam.entity.Event;
import com.epam.entity.Seat;
import com.epam.entity.Ticket;
import com.epam.entity.User;

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
    Map<Ticket, Double> getTicketPrice(Event event, Date date, List<Seat> seats, User user);

    /**
     * Get all purchased tickets for event for specific date
     * @param date - date of event
     * @return
     */
    List<Ticket> getTicketsForEvent(Event event, Date date);

    List<Ticket> bookTicket(User user,Ticket ticket);
}
