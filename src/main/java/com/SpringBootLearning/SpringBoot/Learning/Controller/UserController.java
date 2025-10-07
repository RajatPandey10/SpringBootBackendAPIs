package com.SpringBootLearning.SpringBoot.Learning.Controller;


import com.SpringBootLearning.SpringBoot.Learning.Api.response.WeatherResponse;
import com.SpringBootLearning.SpringBoot.Learning.Entity.User;
import com.SpringBootLearning.SpringBoot.Learning.Repository.UserRepository;
import com.SpringBootLearning.SpringBoot.Learning.Services.UserServices;
import com.SpringBootLearning.SpringBoot.Learning.Services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDB = userServices.findByUserName(userName);
        userInDB.setUserName(user.getUserName());
        userInDB.setPassword(user.getPassword());
        userServices.saveNewUser(userInDB);
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById(){
        Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greeting(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse  = weatherService.getWeather("Mumbai");
        String greeting = "";
        if(weatherResponse != null){
            greeting = ", Weather feels like "+weatherResponse.getCurrent().getFeelsLike();
        }

        return new ResponseEntity("Hi "+authentication.getName() + greeting, HttpStatus.OK);
    }

}
