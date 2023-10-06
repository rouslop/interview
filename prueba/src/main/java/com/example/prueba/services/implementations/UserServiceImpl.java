package com.example.prueba.services.implementations;

import com.example.prueba.model.User;
import com.example.prueba.model.dataTypes.DTUser;
import com.example.prueba.model.repositories.UserRepository;
import com.example.prueba.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Long createUser(String name, String email, Integer age) {
        User usuario = new User(name, email, age);
        return this.userRepository.save(usuario).getId();
    }

    @Override
    public DTUser getUser(Long id) {
        User usuario = this.userRepository.getReferenceById(id);
        return new DTUser(usuario.getId(), usuario.getName(), usuario.getEmail(), usuario.getAge());
    }

    @Override
    public DTUser updateUser(String name, String email, Integer age) {
        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        User usuario = this.userRepository.getReferenceById(id);
        if(usuario!=null){
            this.userRepository.delete(usuario);
            if(this.userRepository.getReferenceById(id)==null){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
