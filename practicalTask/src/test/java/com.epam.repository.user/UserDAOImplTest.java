package com.epam.repository.user;

import com.epam.entity.User;
import com.epam.repository.user.api.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
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

    @Before
    public void setUp() {
        user.setBirthday(new java.util.Date(1436907600000L));
    }

    @Test
    public void testGetUserByIdNotNull() {
        User user = userDAO.getUserById(1);
        assertNotNull(user);
    }

    @Test
    public void testGetUserById() {
        User user = userDAO.getUserById(1);
        assertEquals(this.user, user);
    }

    @Test
    public void testGetUserByEmail() {
        List<User> users = userDAO.getUserByEmail("vasyliev@email.com");
        assertEquals(this.user, users.get(0));
    }

    @Test
    public void testGetUserByFirstName() {
        List<User> users = userDAO.getUsersByFirstName("Yevhen");
        assertEquals(1, users.size());

    }

}
