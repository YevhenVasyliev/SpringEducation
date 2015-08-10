package com.epam.util.discount.api;

import com.epam.entity.Event;
import com.epam.entity.User;

import java.util.Date;

/**
 * Created by Yevhen_Vasyliev on 10.08.2015.
 */
public interface DiscountStrategy {

    int getDiscount(User user, Event event, Date date);

}
