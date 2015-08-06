package com.epam.repository.auditorium;

import com.epam.entity.Auditorium;
import com.epam.entity.Seat;
import com.epam.repository.auditorium.api.AuditoriumDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yevhen_Vasyliev
 */

public class AuditoriumDAOImpl implements AuditoriumDAO {

    private List<Auditorium> auditoriums;

    public AuditoriumDAOImpl(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    @Override
    public List<Auditorium> getAuditoriums() {
        return new ArrayList(auditoriums);
    }

    @Override
    public List<Seat> getSeatsNumber(long auditoriumId) {
        for (Auditorium auditorium : auditoriums) {
            if (auditorium.getId() == auditoriumId) {
                return auditorium.getSeats();
            }
        }
        return null;
    }
// TODO refactoring
    @Override
    public List<Seat> getVipSeats(long auditoriumId) {
        List<Seat> seats = new ArrayList<>();
        for (Auditorium auditorium : auditoriums) {
            if (auditorium.getId() == auditoriumId) {
                for (Seat seat : auditorium.getSeats()) {
                    if (seat.isVip()) {
                        seats.add(seat);
                    }
                }
            }
        }
        return seats;
    }

}
