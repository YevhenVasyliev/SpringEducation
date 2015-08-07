package com.epam.service.user;

import com.epam.entity.User;
import com.epam.service.user.api.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Yevhen_Vasyliev on 07.08.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/appConfig.xml", "classpath:/appConfigTest.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("user_1")
    private User user;

    @Test
    public void testGetByID() {
        User user = userService.getById(1);
        assertEquals(this.user, user);
    }

    @Test
    public void testGetByIdIfUserNotExist() {
        User user = userService.getById(5);
        assertNull(user);
    }

    @Test
    public void testGetByIdCheckingToNull() {
        User user = userService.getById(2);
        assertNotNull(user);
    }

    @Test
    public void testGetUserByFirstName() {
        List<User> users = userService.getUsersByFirstName("Yevhen");
        List<User> expectedUsers = Arrays.asList(this.user);
        assertEquals(expectedUsers, users);
    }

    @Test
    public void testGetUserByFirstNameIfUserNotExist() {
        List<User> users = userService.getUsersByFirstName("NotExist");
        assertEquals(0, users.size());
    }
}
