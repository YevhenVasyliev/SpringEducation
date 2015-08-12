package com.epam.repository.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Yevhen_Vasyliev on 11.08.2015.
 */
public interface InsertQueryMapper<T> {

    void mapForInsert(T entity, PreparedStatement ps) throws SQLException;
}
