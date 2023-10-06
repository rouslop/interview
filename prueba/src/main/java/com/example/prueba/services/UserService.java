package com.example.prueba.services;

import com.example.prueba.model.dataTypes.DTUser;
import org.springframework.stereotype.Service;


public interface UserService {
    public Long createUser(String name, String email, Integer age);
    public DTUser getUser(Long id);
    public DTUser updateUser(String name, String email, Integer age);
    public boolean deleteUser(Long id);
}
