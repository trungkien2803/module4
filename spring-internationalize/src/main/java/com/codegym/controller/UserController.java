package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping("/")
    public ModelAndView signIn(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }
}
