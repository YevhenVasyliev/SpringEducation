package com.epam.service.auditorium.api;

import com.epam.entity.Auditorium;
import com.epam.entity.Seat;

import java.util.List;

/**
 * @author Yevhen_Vasyliev
 */
public interface AuditoriumService {

    List<Auditorium> getAuditoriums();

    List<Seat> getSeatsNumber(long auditoriumId);

    List<Seat> getVipSeats(long auditoriumId);
}
