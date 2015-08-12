package com.epam.repository.user;

/**
 * Created by Yevhen_Vasyliev on 11.08.2015.
 */
public class UserSQLQuery {

    private UserSQLQuery(){}

    public static final String ADD_USER = "INSERT INTO users (first_name, last_name, email, birthday) VALUES (?, ?, ?, ?)";

    public static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id=?";

    public static final String SELECT_USERS_BY_FIRST_NAME = "SELECT * FROM users WHERE first_name = ?";

    public static final String SELECT_USERS_BY_EMAIL = "SELECT * FROM users WHERE email = ?";

    public static final String SELECT_USERS_BY_ID = "SELECT * FROM users WHERE id = ?";
}
