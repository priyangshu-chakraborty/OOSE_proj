package com.example.course.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.Model.User;
import com.example.course.repository.LoginRepo;

@Service
public class RegisterService {
    @Autowired
    private LoginRepo userrepo;
    public User reg(String username,String password)
    {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userrepo.save(user);
    }

}


