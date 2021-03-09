package com.example.mid.services;

import com.example.mid.models.User;

public interface UserService{
void save(User user);
User findByUsername(String username);    
}