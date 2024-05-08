package com.example.course.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.Model.User;
import com.example.course.repository.LoginRepo;

@Service
public class LoginService {

    @Autowired
    private LoginRepo rep;
    public User log(String username,String password)
    {
        User user = rep.findByUsernameAndPassword(username, password);
        return user;   
    }

}

