package com.epam.repository.booking.api;

import com.epam.entity.Event;
import com.epam.entity.Ticket;
import com.epam.entity.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Yevhen_Vasyliev on 06.08.2015.
 */
public interface BookingDAO {

    List<Ticket> getAll();

    List<Ticket> getTicketsByDate(Event event, Date date);

    boolean add(Ticket ticket);

    int getAllBookedTicketByUser(User user);
}
