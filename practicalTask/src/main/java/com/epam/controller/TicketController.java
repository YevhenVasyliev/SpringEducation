package com.epam.controller;

import com.epam.entity.Ticket;
import com.epam.service.booking.api.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Yevhen_Vasyliev on 21.08.2015.
 */
@Controller
public class TicketController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(value="getBookedTicket", method= RequestMethod.GET, headers="Accept=application/pdf")
    public ModelAndView getBookedTicket() {
        List<Ticket> tickets = bookingService.getBookedTickets();
        return new ModelAndView("ticketPDF", "tickets", tickets);
    }


}
