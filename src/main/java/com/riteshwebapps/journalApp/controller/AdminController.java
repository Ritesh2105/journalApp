package com.riteshwebapps.journalApp.controller;

import com.riteshwebapps.journalApp.entity.User;
import com.riteshwebapps.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;
    @GetMapping("/get-users")
    public ResponseEntity<?> getAll(){
        List<User> all = userService.getAll();
        if(all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/create-admin")
    public User createAdmin(@RequestBody User user){
        userService.saveAdmin(user);
        User createdUser = userService.findByUserName(user.getUserName());
        return createdUser;
    }
}
