package com.SpringBootLearning.SpringBoot.Learning.Controller;


import com.SpringBootLearning.SpringBoot.Learning.Entity.JournalEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {



    @GetMapping
    public List<JournalEntry> getAll(){
        return null;
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry){
        return true;
    }
    @GetMapping("id/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return null;

    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<?> deleteEntry(@PathVariable Long id){
        return null;
    }

    @PutMapping("id/{id}")
    public JournalEntry updateEntry(@RequestBody JournalEntry entry, @PathVariable Long id){
        return null;
    }
}
