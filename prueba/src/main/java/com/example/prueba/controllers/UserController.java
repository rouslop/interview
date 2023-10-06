package com.example.prueba.controllers;

import com.example.prueba.model.dataTypes.DTUser;
import com.example.prueba.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<Long> createUser(@RequestBody DTUser user){
        Long id = this.userService.createUser(user.getName(), user.getEmail(), user.getAge());
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTUser> getUser(@PathVariable Long id){
        return ResponseEntity.ok().body(this.userService.getUser(id));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<DTUser> updateUser(@RequestBody DTUser nuevo, @PathVariable Long id){
//
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        if(this.userService.deleteUser(id)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
