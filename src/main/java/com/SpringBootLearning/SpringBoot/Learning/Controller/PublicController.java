package com.SpringBootLearning.SpringBoot.Learning.Controller;

import com.SpringBootLearning.SpringBoot.Learning.Entity.User;
import com.SpringBootLearning.SpringBoot.Learning.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user){
        userServices.saveNewUser(user);
    }
    @GetMapping("/healthCheck")
    public String check(){
        return "ok";
    }
}
