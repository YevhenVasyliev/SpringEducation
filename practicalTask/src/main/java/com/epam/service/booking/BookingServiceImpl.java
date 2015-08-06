package com.epam.service.booking;

import com.epam.entity.Event;
import com.epam.entity.Seat;
import com.epam.entity.Ticket;
import com.epam.entity.User;
import com.epam.repository.ticket.api.TicketDAO;
import com.epam.service.booking.api.BookingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author Yevhen_Vasyliev
 */
public class BookingServiceImpl implements BookingService {

    @Autowired
    private TicketDAO ticketDAO;

    @Override
    public Map<Ticket, Double> getTicketPrice(Event event, Date date, List<Seat> seats, User user) {
        List<Ticket> tickets= ticketDAO.getAllTicket();
        List<Ticket> userTicket = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getIdEvent() == event.getId() &&
                    ticket.getDate().compareTo(date) == 0 &&
                    ticket.getUser().equals(user)) {
                userTicket.add(ticket);
            }
        }
        return getPriceTicket(event, userTicket);
    }

    @Override
    public List<Ticket> getTicketsForEvent(Event event, Date date) {
        List<Ticket> tickets = ticketDAO.getAllTicket();
        List<Ticket> ticketsForEvent = new ArrayList<>();
        for (Ticket ticket : tickets) {

        }
        return null;
    }

    @Override
    public List<Ticket> bookTicket(User user, Ticket ticket) {
        return null;
    }

    private Map<Ticket, Double> getPriceTicket(Event event, List<Ticket> tickets) {
        Map<Ticket, Double> priceOfTickets = new HashMap<>();
        if (tickets != null) {
            for (Ticket ticket : tickets) {
                if (ticket.getSeats().isVip()) {
                    priceOfTickets.put(ticket, event.getPriceVip());
                }
                priceOfTickets.put(ticket, event.getPrice());
            }
        }
        return priceOfTickets;
    }

}
