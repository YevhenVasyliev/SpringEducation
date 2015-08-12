package com.epam.repository.event;

/**
 * Created by Yevhen_Vasyliev on 11.08.2015.
 */
public class EventSQLQuery {

    private EventSQLQuery() {
    }

    public static final String ADD_EVENT = "INSERT INTO events (name, start_date, price, price_vip, rating, auditorium_id) VALUES (?, ?, ?, ?, ?, ?)";

    public static final String GET_EVENT_BY_ID = "SELECT events.id, events.name, events.start_date, events.price, events.price_vip, events.rating, events.auditorium_id," +
            " auditoriums.id, auditoriums.name, seats.id, seats.auditorium_id, seats.`type` FROM events  " +
            "JOIN auditoriums ON events.auditorium_id=auditoriums.id " +
            "JOIN seats ON auditoriums.id=seats.auditorium_id " +
            "WHERE events.id = ?";

    public static final String UPDATE_EVENT_AUDITORIUM = "UPDATE events SET events.auditorium_id = ? WHERE events.id = ?";
}
