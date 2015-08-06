package com.epam.repository.ticket.api;

import com.epam.entity.Ticket;

import java.util.List;

/**
 * @author Yevhen_Vasyliev
 */
public interface TicketDAO {

    List<Ticket> getAllTicket();

}
