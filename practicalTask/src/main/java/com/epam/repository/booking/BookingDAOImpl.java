package com.epam.repository.booking;

import com.epam.entity.Event;
import com.epam.entity.Ticket;
import com.epam.entity.User;
import com.epam.repository.booking.api.BookingDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Yevhen_Vasyliev on 06.08.2015.
 */
@Repository
public class BookingDAOImpl implements BookingDAO {

    private List<Ticket> tickets = new ArrayList<>();

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

    @Override
    public boolean add(Ticket ticket) {
        return tickets.add(ticket);
    }

    public int getAllBookedTicketByUser(User user){
        int counter = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getUser() == user) {
                counter++;
            }
        }
        return counter;
    }
}
