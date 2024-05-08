package com.example.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.Model.User;
import com.example.course.repository.LoginRepo;

@Service
public class CourseRegService {
    @Autowired
    private LoginRepo repo;
    public User deposit(String username,String course)
    {
        User user = repo.findByUsername(username);
        user.setCourse(course);
        return repo.save(user);
    }

}


