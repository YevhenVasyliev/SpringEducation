package com.epam.util.discount;

import com.epam.entity.Event;
import com.epam.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Yevhen_Vasyliev on 10.08.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/appConfig.xml", "classpath:/appConfigTest.xml"})
public class BirthdayStrategyTest {

    @Autowired
    @Qualifier("user_1")
    private User userNotHaveBirthday;

    @Autowired
    @Qualifier("user_2")
    private User userHaveBirthday;

    @Autowired
    @Qualifier("event_1")
    private Event event;

    private BirthdayStrategy birthdayStrategy;

    @Before
    public void setUp() {
        birthdayStrategy = new BirthdayStrategy();
    }

    @Test
    public void testGetDiscountIfUserHaveBirthday() {
        int discount = birthdayStrategy.getDiscount(userHaveBirthday, event, new Date());
        assertEquals(5, discount);
    }

    @Test
    public void testGetDiscountIfUserNotHaveBirthday() {
        int discount = birthdayStrategy.getDiscount(userNotHaveBirthday, event, new Date());
        assertEquals(0, discount);
    }
}
