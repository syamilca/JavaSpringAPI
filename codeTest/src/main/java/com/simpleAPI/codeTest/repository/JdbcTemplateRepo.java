package com.simpleAPI.codeTest.repository;

import com.simpleAPI.codeTest.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

// not used
@Repository
public class JdbcTemplateRepo {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Account(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"));
    }

    public Account getUser(String username) {
        String sql = "SELECT * FROM Users WHERE username=?";

        return jdbcTemplate.queryForObject(sql, new Object[]{username}, JdbcTemplateRepo::mapRow);
    }

}
