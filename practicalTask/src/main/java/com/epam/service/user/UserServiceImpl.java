package com.epam.service.user;

import com.epam.entity.Ticket;
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
    @Autowired
    TicketDAO ticketDAO;

    @Override
    public void register(User user) {
        userDAO.add(user);
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
    public List<User> getUsersByFirstName(String firstName) {
        return userDAO.getUsersByFirstName(firstName);
    }

}
