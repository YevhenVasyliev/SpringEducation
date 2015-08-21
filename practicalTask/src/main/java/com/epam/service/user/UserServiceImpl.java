package com.epam.service.user;

import com.epam.entity.User;
import com.epam.repository.ticket.api.TicketDAO;
import com.epam.repository.user.api.UserDAO;
import com.epam.service.user.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yevhen_Vasyliev
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public User register(User user) {
        return userDAO.add(user);
    }

    @Override
    public void remove(User user) {
        userDAO.remove(user.getId());
    }

    @Override
    public User getById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public List<User> getUsersByFirstName(User user) {
        return userDAO.getUsersByFirstName(user.getFirstName());
    }

    @Override
    public List<User> getUserByEmail(User user) {
        return userDAO.getUserByEmail(user.getEmail());
    }

}
