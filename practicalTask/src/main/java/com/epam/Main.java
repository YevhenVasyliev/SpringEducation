package com.epam;

import com.epam.entity.User;
import com.epam.service.auditorium.api.AuditoriumService;
import com.epam.service.user.api.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        User user = (User) applicationContext.getBean("user_1");
        userService.register(user);
        System.out.println(userService.getById(1));
        System.out.println(userService.getBookedTickets().size());
        System.out.println(applicationContext.getBean(AuditoriumService.class).getAuditoriums());
    }
}
