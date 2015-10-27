package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Wajih Sid on 10/26/2015.
 */
@Service
public class UserService implements UserDAO//,RowMapper<User>
{



    public void updateUser(int id,User user)
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3300/users");
        dataSource.setUsername("root");
        dataSource.setPassword("wajih");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String name = user.getUsername();
        String email = user.getEmail();
        String lang = user.getFavProgrammingLanguage();
        String sql = "UPDATE SURVEY SET name = ?,email = ?, lang = ? WHERE id=?";

        jdbcTemplate.update(sql,name,email,lang,id);


    }
    public void deleteUser(int id)
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3300/users");
        dataSource.setUsername("root");
        dataSource.setPassword("wajih");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "DELETE * FROM SURVEY WHERE id=?";
        jdbcTemplate.update(sql,id);

    }
    @Override
    public void createUser(User user) throws SQLException {


        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3300/emp");
        dataSource.setUsername("root");
        dataSource.setPassword("wajih");
        JdbcTemplate jdbcTemplate= new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        String sql = "INSERT INTO SURVEY(id,name,email,lang) VALUES(?,?,?,?)";

        jdbcTemplate.update(sql,1,user.getUsername(), user.getEmail(), user.getFavProgrammingLanguage());

    }

    @Override
    public  void delete(int userId) {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3300/emp");
        dataSource.setUsername("root");
        dataSource.setPassword("wajih");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setDataSource(dataSource);
        String sqlDeleteUser = "DELETE * from SURVEY WHERE id=?";
        jdbcTemplate.update(sqlDeleteUser,userId);
        System.out.println("Deleted User");
    }

    @Override
    public List<User> getAllUsers()
    {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3300/emp");
        dataSource.setUsername("root");
        dataSource.setPassword("wajih");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sqlAll = "SELECT * from SURVEY";
        final List<User> listUser = jdbcTemplate.query(sqlAll, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User aUser = new User();

                aUser.setEmail(rs.getString("email"));
                aUser.setUsername(rs.getString("name"));
                aUser.setFavProgrammingLanguage(rs.getString("lang"));
                return aUser;
            }
        });

        return listUser;


    }

    @Override
    public User getUserById(int id) throws SQLException {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3300/emp");
        dataSource.setUsername("root");
        dataSource.setPassword("wajih");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setDataSource(dataSource);
        String sql = "SELECT * FROM SURVEY WHERE id=" + id;



        User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUsername(resultSet.getString(1));
                user.setEmail(resultSet.getString(2));
                user.setFavProgrammingLanguage(resultSet.getString(3));
                return user;
            }
        });

        return null;
    }


    }


