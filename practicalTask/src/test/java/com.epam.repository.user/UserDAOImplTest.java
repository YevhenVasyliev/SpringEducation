package com.epam.repository.user;

import com.epam.entity.User;
import com.epam.repository.user.api.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Yevhen_Vasyliev on 06.08.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/appConfig.xml", "classpath:/appConfigTest.xml"})
public class UserDAOImplTest {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    @Qualifier("user_1")
    private User user;

    @Test
    public void testGetUserByIdNotNull() {
        User user = userDAO.getUserById(1);
        assertNotNull(user);
    }

    @Test
    public void testGetUserByIdIfUserIsNotExist() {
        User user = userDAO.getUserById(3);
        assertNull(user);
    }

    @Test
    public void testGetUserById() {
        User user = userDAO.getUserById(1);
        assertEquals(this.user, user);
    }

    @Test
    public void testGetUserByEmail() {
        User user = userDAO.getUserByEmail("vasyliev@email.com");
        assertEquals(this.user, user);
    }

    @Test
    public void testGetUserByFirstName() {
        List<User> users = userDAO.getUsersByFirstName("Yevhen");
        assertEquals(1, users.size());

    }

}
