package com.epam.repository.ticket;

/**
 * Created by Yevhen_Vasyliev on 12.08.2015.
 */
public class TicketSQLQuery {

    private TicketSQLQuery() {
    }

    public static final String ADD_TICKET = "INSERT tickets (event_id, user_id, seat_id, event_date) VALUES (?, ?, ?, ?)";

    public static final String GET_ALL_TICKET = "SELECT tickets.id, tickets.event_Id, tickets.user_Id, tickets.seat_Id, tickets.event_date FROM tickets";

    public static final String GET_TICKET_BY_EVENT_SEAT_USER = "SELECT tickets.id, tickets.event_Id, tickets.user_Id, tickets.seat_Id, tickets.event_date FROM tickets WHERE event_id = ? AND user_id = ? AND event_date = ?";

    public static final String GET_TICKET_BY_USER = "SELECT tickets.id, tickets.event_Id, tickets.user_Id, tickets.seat_Id, tickets.event_date FROM tickets WHERE user_id = ?";
}
