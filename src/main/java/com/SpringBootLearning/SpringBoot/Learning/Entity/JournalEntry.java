package com.SpringBootLearning.SpringBoot.Learning.Entity;


import lombok.Data;
import org.springframework.stereotype.Controller;

@Controller
@Data

public class JournalEntry {
    private long id;
    private String title;
    private String content;


}
