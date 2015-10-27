package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("UsersController")

public class UserController
{
    @Autowired
    UserService userService;

    @Autowired
    DataSource dataSource;





//    private SimpleDriverDataSource dataSource;

	@RequestMapping(value="/" ,method = RequestMethod.GET)
	public String printWelcome(ModelMap model)
    {

    	model.addAttribute("message", "Hello world!");
		return "signupform";
	}


	@RequestMapping(value="/newuser",method = RequestMethod.POST)
	public String insertUser(@RequestParam("useremail") String email,@RequestParam("username") String username,@RequestParam("favProgramming") String favProgramming,ModelMap map)
	{
		User newUser = new User(username,email,favProgramming);
        System.out.println(newUser);
        map.addAttribute("User", newUser);
        try
        {
            userService.createUser(newUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "displayUser";
	}
    @RequestMapping(value="/getUser",method = RequestMethod.GET)
    public void getUser(@RequestParam("id") int id)
    {
        try
        {
            User user = userService.getUserById(id);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }



    @RequestMapping(value = "update/{int}" ,method = RequestMethod.PUT)
    public @ResponseBody void updateUser(@PathVariable("int") int id,@RequestParam(value= "useremail",defaultValue = "wajihsid@gmail.com") String useremail,@RequestParam(value= "username",defaultValue = "WajihulHaq") String username,@RequestParam(value="favProgramming",defaultValue = "JAVA") String favProgramming)
    {
        User user = new User(useremail,username,favProgramming);
            userService.updateUser(id, user);
        ModelMap modelMap = new ModelMap();
        System.out.println("User updated");
    }

    @RequestMapping(value = "delete/{int}" ,method = RequestMethod.DELETE)
    public @ResponseBody void deleteUser(@PathVariable("int") int id)
    {

        userService.deleteUser(id);
        ModelMap modelMap = new ModelMap();
        System.out.println("Deleted User!");
    }


}