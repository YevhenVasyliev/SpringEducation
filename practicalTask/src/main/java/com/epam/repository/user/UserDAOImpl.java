package com.epam.repository.user;

import com.epam.entity.User;
import com.epam.repository.user.api.UserDAO;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yevhen_Vasyliev
 */
@Repository
public class UserDAOImpl implements UserDAO{

    private List<User> users;

    public UserDAOImpl() {
    }

    public UserDAOImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public User getUserById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUsersByFirstName(String firstName) {
        List<User> suitableUsers = new ArrayList<User>();
        for (User user : users) {
            if (user.getFirstName().equals(firstName)) {
                suitableUsers.add(user);
            }
        }
        return suitableUsers;
    }

    @Override
    public void remove(long id) {
        for (User user : users) {
            if(user.getId() == id) {
                users.remove(user);
            }
        }
    }

    @Override
    public void add(User user) {
        users.add(user);
    }
}
