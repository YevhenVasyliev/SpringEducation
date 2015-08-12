package com.epam.repository.auditorium;

import com.epam.entity.Auditorium;
import com.epam.entity.Seat;
import com.epam.repository.auditorium.api.AuditoriumDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import static com.epam.repository.auditorium.AuditoriumSQLQuery.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Yevhen_Vasyliev
 */
@Repository
public class AuditoriumDAOImpl implements AuditoriumDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AuditoriumMapper auditoriumMapper;

    @Autowired
    private SeatMapper seatMapper;

    @Override
    public List<Auditorium> getAuditoriums() {
        return jdbcTemplate.query(SELECT_ALL_AUDITORIUMS, auditoriumMapper);
    }

    @Override
    public List<Seat> getSeatsNumber(long auditoriumId) {
        return jdbcTemplate.query(SELECT_ALL_SEATS, seatMapper, auditoriumId);
    }

    @Override
    public List<Seat> getVipSeats(long auditoriumId) {
        Object[] args = {auditoriumId, "VIP"};
        return jdbcTemplate.query(SELECT_ALL_VIP_SEATS, seatMapper, args);
    }

}
