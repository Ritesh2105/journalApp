//package com.riteshsoftwares.journalApp.controller;
//
//import entity.com.riteshwebapps.journalApp.User;
//import repository.com.riteshwebapps.journalApp.UserRepository;
//import service.com.riteshwebapps.journalApp.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/user")
//public class UserControllerV1 {
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private UserRepository userRepository;
//
////    @GetMapping
////    public List<User> getUser(){
////        return userService.getAll();
////    }
//
////    @PostMapping
////    public ResponseEntity createUser(@RequestBody User newUser){
////        try{
////            userService.saveEntry(newUser);
////            return new ResponseEntity(HttpStatus.CREATED);
////        }
////        catch (Exception e) {
////            return new ResponseEntity(HttpStatus.BAD_REQUEST);
////        }
////    }
//
//    @PutMapping("/{oldUserName}")
//    public ResponseEntity<User> updateUser(@PathVariable String oldUserName, @RequestBody User updateUser){
//        User oldUser = userService.findByUserName(oldUserName);
//        if(oldUser != null){
//            oldUser.setUserName(updateUser.getUserName());
//            oldUser.setPassword(updateUser.getPassword());
//            userService.saveEntry(oldUser);
//            return new ResponseEntity<>(oldUser, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//
//    @DeleteMapping("/{userName}")
//    public ResponseEntity deleteUser(@PathVariable String userName){
//        try {
//            userService.deleteByUserName(userName);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        catch(Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//}
