package com.epam.repository.booking;

import com.epam.entity.Event;
import com.epam.entity.Ticket;
import com.epam.repository.booking.api.BookingDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Yevhen_Vasyliev on 06.08.2015.
 */
public class BookingDAOImpl implements BookingDAO {

    private List<Ticket> tickets;

    public BookingDAOImpl(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public List<Ticket> getAll() {
        return new ArrayList<>(tickets);
    }

    @Override
    public List<Ticket> getTicketsByDate(Event event, Date date) {
        List<Ticket> bookedTicket = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getIdEvent() == event.getId() && ticket.getDate().equals(date)) {
                bookedTicket.add(ticket);
            }
        }
        return bookedTicket;
    }
}
