package com.epam.repository.auditorium;

import com.epam.entity.Auditorium;
import com.epam.entity.Seat;
import com.epam.entity.SeatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yevhen_Vasyliev on 11.08.2015.
 */
@Component
public class AuditoriumMapper implements ResultSetExtractor<List<Auditorium>> {

    @Override
    public List<Auditorium> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Long, Auditorium> auditoriumMap = new HashMap<>();
        List<Seat> seats;
        while (rs.next()) {
            Auditorium auditorium;
            if (auditoriumMap.containsKey(rs.getLong("auditoriums.id"))) {
                auditorium = auditoriumMap.get(rs.getLong("auditoriums.id"));
            } else {
                auditorium = getAuditorium(rs);
            }
            Seat seat = mapRow(rs);
            seats = getSeats(auditorium);
            seats.add(seat);
        }
        return new ArrayList<>(auditoriumMap.values());
    }

    private Auditorium getAuditorium(ResultSet rs) throws SQLException {
        Auditorium auditorium = new Auditorium();
        auditorium.setId(rs.getLong("auditoriums.id"));
        auditorium.setName(rs.getString("auditoriums.name"));
        return auditorium;
    }

    private List<Seat> getSeats(Auditorium auditorium) {
        return auditorium.getSeats() != null ? auditorium.getSeats() : new ArrayList<Seat>();
    }

    private Seat mapRow(ResultSet rs) throws SQLException {
        Seat seat = new Seat();
        seat.setId(rs.getLong("seats.id"));
        seat.setId(rs.getLong("seats.auditorium_id"));
        seat.setSeatType(SeatType.valueOf(rs.getString("seats.type")));
        return seat;
    }
}
