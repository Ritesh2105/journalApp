package com.riteshwebapps.journalApp.controller;

import com.riteshwebapps.journalApp.entity.User;
import com.riteshwebapps.journalApp.repository.UserRepository;
import com.riteshwebapps.journalApp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

//    @GetMapping
//    public List<User> getUser(){
//        return userService.getAll();
//    }

//    @PostMapping
//    public ResponseEntity createUser(@RequestBody User newUser){
//        try{
//            userService.saveEntry(newUser);
//            return new ResponseEntity(HttpStatus.CREATED);
//        }
//        catch (Exception e) {
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User updateUser){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByUserName(userName);
            userInDb.setUserName(updateUser.getUserName());
            userInDb.setPassword(updateUser.getPassword());
            userService.saveEntry(userInDb);
            return new ResponseEntity<>(userInDb, HttpStatus.OK);
    }
//@PutMapping
//public ResponseEntity<User> updateUser(@RequestBody User updateUser){
//    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    User userInDb = userService.findByUserName(auth.getName());
//
//    userService.updateUser(userInDb, updateUser.getUserName(), updateUser.getPassword());
//
//    return new ResponseEntity<>(userInDb, HttpStatus.OK);
//}


    @DeleteMapping
    public ResponseEntity deleteUser( ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        try {
            userService.deleteByUserName(authentication.getName());
            throw new RuntimeException("Exception Occurred");
//            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e) {
            log.info("Exception "+ e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
