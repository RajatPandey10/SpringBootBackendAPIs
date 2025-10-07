package com.SpringBootLearning.SpringBoot.Learning.Service;

import com.SpringBootLearning.SpringBoot.Learning.Services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    void testSendMail(){
        emailService.sendEmail("pandeyrajat9971@gmail.com","Testing","Hyy");
    }
}
