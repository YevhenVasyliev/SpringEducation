package com.epam.util.discount;

import com.epam.entity.Event;
import com.epam.entity.User;
import com.epam.util.discount.api.DiscountStrategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Yevhen_Vasyliev on 10.08.2015.
 */
public class BirthdayStrategy implements DiscountStrategy {

    private int discount;

    public BirthdayStrategy() {
        Properties property = new Properties();
        try (InputStream inpStream = BirthdayStrategy.class.getResourceAsStream("/settingsForDiscount.properties")){
            property.load(inpStream);
            String discountFromProp = property.getProperty("birthdayDiscount");
            discount = Integer.parseInt(discountFromProp);
        } catch (IOException ex) {
            System.out.println("Property file \"settingsForDiscount.properties\" not found.");
        } catch (NumberFormatException ex) {
            System.out.println("Wrong number format from property file \"settingsForDiscount.properties\".");
        }
    }

    @Override
    public int getDiscount(User user, Event event, Date date) {
        Calendar birthday = Calendar.getInstance();
        birthday.setTime(user.getBirthday());
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        if (birthday.get(Calendar.MONTH) == today.get(Calendar.MONTH) &&
                birthday.get(Calendar.DATE) == today.get(Calendar.DATE)) {
            return discount;
        }
        return 0;
    }
}
