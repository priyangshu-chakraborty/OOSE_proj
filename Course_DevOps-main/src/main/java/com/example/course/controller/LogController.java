package com.example.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;
import com.example.course.Model.User;
import com.example.course.services.CourseRegService;
import com.example.course.services.LoginService;
import com.example.course.services.RegisterService;


@Controller
public class LogController {
 
    @Autowired
    private LoginService service;
    @Autowired
    private RegisterService service2;
    @Autowired
    private CourseRegService service3;
 
    @GetMapping("/")
    public String api()
    {
        return "login";
    }
 
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user) {
 
        User oauthUser = service.log(user.getUsername(), user.getPassword());
 
        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/home";
        } else {
            return "redirect:/";
        }
    }
 
    
    @GetMapping("/register")
    public String api2()
    {
        return "register";
    }
 
    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user) {
 
        User oauthUser = service2.reg(user.getUsername(), user.getPassword());
 
        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/";
        } else {
            return "redirect:/register";
        }
    }

    @GetMapping("/home")
    public String display() {
        return "home";
    }
    @PostMapping("/home")
    public String regcourse(@ModelAttribute("user") User user ) {
        User ouser = service3.deposit(user.getUsername(),user.getCourse());
        System.out.print(ouser);
        if (Objects.nonNull(ouser)) {
            return "redirect:/home";
        } else {
            return "redirect:/deposit";
        }
    }
    
}
