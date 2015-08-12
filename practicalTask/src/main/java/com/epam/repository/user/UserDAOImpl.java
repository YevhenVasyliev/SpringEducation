package com.epam.repository.user;

import com.epam.entity.User;
import com.epam.repository.user.api.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.epam.repository.user.UserSQLQuery.*;

/**
 * @author Yevhen_Vasyliev
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    public UserDAOImpl() {
    }

    @Override
    public User getUserById(long id) {
        return jdbcTemplate.queryForObject(SELECT_USERS_BY_ID, userMapper, id);
    }

    @Override
    public List<User> getUserByEmail(String email) {
        return jdbcTemplate.query(SELECT_USERS_BY_EMAIL, userMapper, email);
    }

    @Override
    public List<User> getUsersByFirstName(String firstName) {
        return jdbcTemplate.query(SELECT_USERS_BY_FIRST_NAME, userMapper, firstName);
    }

    @Override
    public void remove(long id) {
        jdbcTemplate.update(DELETE_USER_BY_ID, id);
    }

    @Override
    public User add(User user) {
        int userId =  jdbcTemplate.update(ADD_USER, userMapper, user);
        user.setId(userId);
        return user;
    }
}
