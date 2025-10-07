package com.SpringBootLearning.SpringBoot.Learning.UserRepositoryTest;

import com.SpringBootLearning.SpringBoot.Learning.Repository.UserRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;


@SpringBootTest
public class UserRepositoryImplTests {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Test
    public void testSaveNewUser(){
        userRepository.getUserForSA();
    }
    @Test
    public void testAdd(){
        Assertions.assertEquals(4,2+2);
    }
}
