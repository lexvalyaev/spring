package com.sprhib.controller;
import java.util.List;

import com.sprhib.model.User;
import com.sprhib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/user")
public class UserController  {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addUserPage()
    {
        ModelAndView modelAndView = new ModelAndView("add-user-form");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView addingUser(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView("list-of-users");
        if(user.getAdmin()!=null){user.setAdmin(true);}
        if(user.getAdmin()==null){user.setAdmin(false);}
        userService.addUser(user);
        String message = "User was successfully added.";
        modelAndView.addObject("message", message);
        List<User> users = userService.getUsers();
        modelAndView.addObject("users", users);
        return modelAndView;
    }


    @RequestMapping(value="/list")
    public ModelAndView listOfUsers() {
        ModelAndView modelAndView = new ModelAndView("list-of-users");
        List<User> users = userService.getUsers();
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editUserPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-user-form");
        User user = userService.getUser(id);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edditingUser(@ModelAttribute User user, @PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("list-of-users");
        userService.updateUser(user);
        String message = "User was successfully updated.";
        modelAndView.addObject("message", message);
        List<User> users = userService.getUsers();
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("list-of-users");
        userService.deleteUser(id);
        String message = "User was successfully deleted.";
        modelAndView.addObject("message", message);
        List<User> users = userService.getUsers();
        modelAndView.addObject("users", users);
        return modelAndView;
    }

}
