package com.SpringBootLearning.SpringBoot.Learning.Service;

import com.SpringBootLearning.SpringBoot.Learning.Entity.User;
import com.SpringBootLearning.SpringBoot.Learning.Repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUserName(){

//        checks if user is in db or not
        assertNotNull(userRepository.findByUserName("Rajat"));
    }

    @Disabled
    @Test
    public void testAdd(){
        assertEquals(4,2+2);
    }

//    @Disabled
    @Test
    public void testUsersJournalEntry(){
        User user = userRepository.findByUserName("Rajat");
        assertTrue(!user.getJournalEntries().isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings ={
            "1,1,2",
            "2,10,12",
            "2,3,9"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected,a+b,"Failed for: "+expected);
    }

}
