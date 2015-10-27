package com.springapp.mvc;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Wajih Sid on 10/25/2015.
 */
public interface UserDAO
{
    public void createUser(User user) throws SQLException;
    public void delete(int userId);
    public List<User> getAllUsers();
    public User getUserById(int id) throws SQLException;


}
