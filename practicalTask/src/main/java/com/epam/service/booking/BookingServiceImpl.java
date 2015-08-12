package com.epam.service.booking;

import com.epam.entity.*;
import com.epam.repository.booking.api.BookingDAO;
import com.epam.repository.ticket.api.TicketDAO;
import com.epam.service.booking.api.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Yevhen_Vasyliev
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private TicketDAO ticketDAO;

    @Override
    public Map<UserTicket, Double> getTicketPrice(Event event, Date date, List<Seat> seats, User user) {
        event.setStartDate(date);
        List<UserTicket> tickets= ticketDAO.getTicketsByDateAndUserAndSeats(event, seats, user);
        return getPriceTicket(event, tickets);
    }

    @Override
    public List<Ticket> getTicketsForEvent(Event event, Date date) {
        List<Ticket> tickets = ticketDAO.getAllTicket();
        List<Ticket> purchasedTicketsForEvent = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getIdEvent() == event.getId() && ticket.getDate().equals(date)) {
                purchasedTicketsForEvent.add(ticket);
            }
        }
        return purchasedTicketsForEvent;
    }

    @Override
    public Ticket bookTicket(Ticket ticket) {
        return ticketDAO.add(ticket);
    }

    @Override
    public List<Ticket> getBookedTickets() {
        return ticketDAO.getAllTicket();
    }

    private Map<UserTicket, Double> getPriceTicket(Event event, List<UserTicket> tickets) {
        Map<UserTicket, Double> priceOfTickets = new HashMap<>();
        if (tickets != null) {
            for (UserTicket ticket : tickets) {
                if (ticket.getSeat().getSeatType().equals(SeatType.VIP)) {
                    priceOfTickets.put(ticket, event.getPriceVip());
                }
                priceOfTickets.put(ticket, event.getPrice());
            }
        }
        return priceOfTickets;
    }

    public List<UserTicket> getAllBookedTicketByUser(User user){
        return ticketDAO.getAllBookedTicketByUser(user.getId());
    }

}
