package com.epam.repository.user;

import com.epam.entity.User;
import com.epam.repository.util.InsertQueryMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Yevhen_Vasyliev on 11.08.2015.
 */
@Component
public class UserMapper implements RowMapper<User>, InsertQueryMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setBirthday(rs.getDate("birthday"));
        return user;
    }

    @Override
    public void mapForInsert(User user, PreparedStatement ps) throws SQLException {
        ps.setString(1, user.getFirstName());
        ps.setString(2, user.getLastName());
        ps.setString(3, user.getEmail());
        Date userBirthday = new Date(user.getBirthday().getTime());
        ps.setDate(4, userBirthday);
    }
}
