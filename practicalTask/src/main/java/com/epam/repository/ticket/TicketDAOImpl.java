package com.epam.repository.ticket;

import com.epam.entity.Ticket;
import com.epam.repository.ticket.api.TicketDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yevhen_Vasyliev
 */
@Repository
public class TicketDAOImpl implements TicketDAO {

    private List<Ticket> tickets;

    @Override
    public List<Ticket> getAllTicket() {
        return new ArrayList<Ticket>(tickets);
    }
}
