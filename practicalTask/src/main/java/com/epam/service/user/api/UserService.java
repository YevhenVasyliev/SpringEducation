package com.epam.service.user.api;

import com.epam.entity.Ticket;
import com.epam.entity.User;

import java.util.List;

/**
 * @author Yevhen_Vasyliev
 */
public interface UserService {

    User register(User user);

    void remove(User user);

    User getById(long id);

    List<User> getUsersByFirstName(User user);

    List<User> getUserByEmail(User user);

}
