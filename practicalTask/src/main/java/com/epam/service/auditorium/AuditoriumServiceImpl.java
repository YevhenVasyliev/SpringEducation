package com.epam.service.auditorium;

import com.epam.entity.Auditorium;
import com.epam.entity.Seat;
import com.epam.repository.auditorium.api.AuditoriumDAO;
import com.epam.service.auditorium.api.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yevhen_Vasyliev
 */
@Service
public class AuditoriumServiceImpl implements AuditoriumService {

    @Autowired
    AuditoriumDAO auditoriumDAO;

    @Override
    public List<Auditorium> getAuditoriums() {
        return auditoriumDAO.getAuditoriums();
    }

    @Override
    public List<Seat> getSeatsNumber(long auditoriumId) {
        return auditoriumDAO.getSeatsNumber(auditoriumId);
    }

    @Override
    public List<Seat> getVipSeats(long auditoriumId) {
        return auditoriumDAO.getVipSeats(auditoriumId);
    }
}
