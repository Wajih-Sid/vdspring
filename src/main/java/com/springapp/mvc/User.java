package com.springapp.mvc;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Wajih Sid on 10/25/2015.
 */
public class User
{

    private String Email;
    private String Username;
    private String FavProgrammingLanguage;


    public User(String email, String username, String favProgrammingLanguage) {
        Email = email;
        Username = username;
        FavProgrammingLanguage = favProgrammingLanguage;

    }

    public User() {

    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setFavProgrammingLanguage(String favProgrammingLanguage) {
        FavProgrammingLanguage = favProgrammingLanguage;
    }

    public String getEmail() {
        return Email;
    }

    public String getUsername() {
        return Username;
    }

    public String getFavProgrammingLanguage() {
        return FavProgrammingLanguage;
    }

    @Override
    public String toString() {
        return "User{" +
                "Email='" + Email + '\'' +
                ", Username='" + Username + '\'' +
                ", FavProgrammingLanguage='" + FavProgrammingLanguage + '\'' +
                '}';
    }


}
