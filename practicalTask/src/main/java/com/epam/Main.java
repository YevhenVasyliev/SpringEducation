package com.epam;

import com.epam.entity.Event;
import com.epam.entity.User;
import com.epam.repository.event.EventDAOImpl;
import com.epam.repository.event.api.EventDAO;
import com.epam.service.auditorium.api.AuditoriumService;
import com.epam.service.user.api.UserService;
import com.epam.util.discount.BirthdayStrategy;
import com.epam.util.discount.api.DiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author Yevhen_Vasyliev
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/appConfig.xml");
        for (String s : applicationContext.getBeanDefinitionNames()) {
            System.out.println(s);
        }
        UserService userService = applicationContext.getBean(UserService.class);
        User user = (User) applicationContext.getBean("user_2");
        userService.register(user);
        System.out.println(userService.getById(1));
        System.out.println(applicationContext.getBean(AuditoriumService.class).getAuditoriums());

        // Test aspect when try add new event
        Event event = (Event) applicationContext.getBean("event_1");
        EventDAO eventDAO = (EventDAO) applicationContext.getBean("eventDAO");
        eventDAO.add(event);

        // Test aspect when use birthday discount
        DiscountStrategy birthdayStrategy = (DiscountStrategy) applicationContext.getBean("birthdayDiscount");
        int i = birthdayStrategy.getDiscount(user, event, new Date());
        System.out.println(i);
    }
}
