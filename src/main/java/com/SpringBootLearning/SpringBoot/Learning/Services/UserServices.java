package com.SpringBootLearning.SpringBoot.Learning.Services;

import com.SpringBootLearning.SpringBoot.Learning.Entity.User;
import com.SpringBootLearning.SpringBoot.Learning.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public void saveEntry(User user){
        userRepository.save(user);
    }


    public void saveNewUser(User user){
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
        }catch (Exception e){
            log.error("error occurred for {} :",user.getUserName(),e);
//            logger.warn("Hey I am logger");
//            logger.error("Hey I am logger");
//            logger.trace("Hey I am logger");
//            logger.debug("Hey I am logger");
        }

    }

    public void saveAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepository.save(user);
    }

    public List<User> getAll(){

        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);

    }

    public  void deleteById(ObjectId id){

        userRepository.deleteById(id);
    }

    public  User findByUserName(String username){

        return userRepository.findByUserName(username);
    }
}
