package com.epam.util.discount;

import com.epam.entity.Event;
import com.epam.entity.User;
import com.epam.service.booking.api.BookingService;
import com.epam.util.discount.api.DiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Yevhen_Vasyliev on 10.08.2015.
 */
public class EveryTenthDiscountStrategy implements DiscountStrategy{

    @Autowired
    private BookingService bookingService;

    private int discount;

    public EveryTenthDiscountStrategy() {
        Properties property = new Properties();
        try (InputStream inputStream = BirthdayStrategy.class.getResourceAsStream("/settingsForDiscount.properties")){
            property.load(inputStream);
            String discountFromProp = property.getProperty("everyTenthDiscount");
            discount = Integer.parseInt(discountFromProp);
        } catch (IOException ex) {
            System.out.println("Property file \"settingsForDiscount.properties\" not found.");
        } catch (NumberFormatException ex) {
            System.out.println("Wrong number format from property file \"settingsForDiscount.properties\".");
        }
    }

    @Override
    public int getDiscount(User user, Event event, Date date) {
        int countOfTicket = bookingService.getAllBookedTicketByUser(user).size();
        if (countOfTicket != 0 && countOfTicket % 10 == 0) {
            return discount;
        }
        return 0;
    }

}
