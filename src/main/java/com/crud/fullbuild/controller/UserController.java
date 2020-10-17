package com.crud.fullbuild.controller;


import com.crud.fullbuild.entity.User;
import com.crud.fullbuild.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping() //test service
    public String check(){
        return "Welcome to java spring";
    }

    @GetMapping(path="/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping(path="/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping(path="/addUserList")
    public List<User> addUserList(@RequestBody List<User> userList){
        return userService.addUserList(userList);
    }

    @DeleteMapping(path="/deleteUserById/{id}")
    public User deleteUserById(@PathVariable long id){
        return userService.deleteUserById(id);
    }

    @PutMapping(path = "/updateUserById/{id}")
    public User updateUserById(@PathVariable("id") long id, @RequestBody User user){
        return userService.updateUserById(id, user);
    }

    @GetMapping(path = "/getUserById/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @GetMapping(path = "/getUserByName/{name}")
    public User getUserByName(@PathVariable String name){
        return userService.getUserByName(name);
    }

    @GetMapping(path = "/getUserByNameLike/{name}")
    public List<User> getUserByNameLike(@PathVariable String name){
        return userService.getUserByNameLike(name);
    }



}
