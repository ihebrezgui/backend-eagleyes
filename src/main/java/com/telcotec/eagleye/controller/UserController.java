package com.telcotec.eagleye.controller;


import com.telcotec.eagleye.dao.entities.Technicien;
import com.telcotec.eagleye.service.classes.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/registration")
    public Technicien createNewUser(@RequestBody Technicien user) {
        return userService.saveUser(user);
    }
}

