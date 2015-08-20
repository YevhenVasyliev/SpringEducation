package com.epam.controller;

import com.epam.entity.User;
import com.epam.service.user.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Yevhen_Vasyliev on 18.08.2015.
 */
@Controller
@RequestMapping(value = "user/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "loginform", method = RequestMethod.GET)
    public String registerUser(User user) {
        System.out.println("DEBUG: user/register");
        return "loginForm";
    }

    @RequestMapping(value = "getById/{userId}", method = RequestMethod.GET)
    public ModelAndView getUserById(@PathVariable("userId") Long userId){
        User user = userService.getById(userId);
        ModelAndView modelAndView = new ModelAndView("user/showUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
