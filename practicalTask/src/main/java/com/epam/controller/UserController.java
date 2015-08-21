package com.epam.controller;

import com.epam.DTO.LoginFormBean;
import com.epam.DTO.UserFormBean;
import com.epam.controller.util.ConverterUserDtoToUser;
import com.epam.entity.User;
import com.epam.service.user.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Yevhen_Vasyliev on 18.08.2015.
 */
@Controller
@RequestMapping(value = "user/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ConverterUserDtoToUser converterUserDtoToUser;

    @RequestMapping(value = "loginForm", method = RequestMethod.GET)
    public String registerUser(LoginFormBean user) {
        return "loginForm";
    }

    @RequestMapping(value = "getById/{userId}", method = RequestMethod.GET)
    public ModelAndView getUserById(@PathVariable("userId") Long userId){
        User user = userService.getById(userId);
        ModelAndView modelAndView = new ModelAndView("user/showUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "add", method=RequestMethod.POST)
    public String registerUser(UserFormBean userFormBean, Model model) {
        User user = converterUserDtoToUser.convert(userFormBean);
        userService.register(user);
        model.addAttribute("user", user);
        return "index";
    }
;
    @RequestMapping(value = "remove", method=RequestMethod.POST)
    public String removeUser(User user){
        userService.remove(user);
        return "";
    }

    @RequestMapping(value = "registerForm", method=RequestMethod.GET)
    public String getRegisterForm(){
        return "user/registerForm";
    }

    @RequestMapping(value = "email/{email}", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserByEmail(@PathVariable("email") String email) {
        User user = new User();
        user.setEmail(email);
        return userService.getUserByEmail(user);
    }

    @RequestMapping(value = "userFirsName/{firstName}", method=RequestMethod.GET)
    public List<User> getUserByFirstName(@PathVariable("firstName") String firstName){
        User user = new User();
        user.setFirstName(firstName);
        return userService.getUsersByFirstName(user);
    }
 }
