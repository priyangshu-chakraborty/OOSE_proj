package com.example.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.course.Model.User;


@Repository
public interface LoginRepo extends JpaRepository<User ,String> {
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
}