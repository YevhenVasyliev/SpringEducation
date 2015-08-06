package com.epam.repository.user.api;

import com.epam.entity.User;

import java.util.List;

/**
 * @author Yevhen_Vasyliev
 */
public interface UserDAO {

    User getUserById(long id);

    User getUserByEmail(String email);

    List<User> getUsersByFirstName(String firstName);

    void remove(long id);

    void add(User user);

}
