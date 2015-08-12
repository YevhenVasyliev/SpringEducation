package com.epam.repository.auditorium;

/**
 * Created by Yevhen_Vasyliev on 12.08.2015.
 */
public class AuditoriumSQLQuery {

    private AuditoriumSQLQuery() {
    }

    public static final String SELECT_ALL_AUDITORIUMS = "SELECT auditoriums.id, auditoriums.name, seats.id, seats.auditorium_id, seats.`type` FROM auditoriums " +
            "JOIN seats ON auditoriums.id=seats.auditorium_id";

    public static final String SELECT_ALL_SEATS = "SELECT seats.id, seats.auditorium_id, seats.`type` FROM seats WHERE seats.auditorium_id = ?";

    public static final String SELECT_ALL_VIP_SEATS = "SELECT seats.id, seats.auditorium_id, seats.`type` FROM seats WHERE seats.auditorium_id = ? AND seats.`type` = ?";
}
