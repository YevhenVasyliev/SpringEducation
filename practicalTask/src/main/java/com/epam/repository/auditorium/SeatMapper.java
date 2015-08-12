package com.epam.repository.auditorium;

import com.epam.entity.Seat;
import com.epam.entity.SeatType;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen_Vasyliev on 12.08.2015.
 */
@Component
public class SeatMapper implements RowMapper<Seat> {

    @Override
    public Seat mapRow(ResultSet rs, int rowNum) throws SQLException {
        Seat seat = new Seat();
        seat.setId(rs.getLong("seats.id"));
        seat.setId(rs.getLong("seats.auditorium_id"));
        seat.setSeatType(SeatType.valueOf(rs.getString("seats.type")));
        return seat;
    }
}
