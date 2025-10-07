package com.SpringBootLearning.SpringBoot.Learning.Services;

import com.SpringBootLearning.SpringBoot.Learning.Entity.JournalEntry;
import com.SpringBootLearning.SpringBoot.Learning.Entity.User;
import com.SpringBootLearning.SpringBoot.Learning.Repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JournalEntryServices {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserServices userServices;


    @Transactional
    public void saveNewEntry(JournalEntry journalEntry, String userName){
        try{
            User user = userServices.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userServices.saveEntry(user);
        }catch (Exception e){
           log.error("error ",e);
            throw new RuntimeException("An error occurred",e);
        }


    }
    public void saveNewEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);

    }


    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);

    }

    @Transactional
    public  boolean deleteById(ObjectId id, String username){
        boolean removed = false;
        try{
            User user = userServices.findByUserName(username);
             removed = user.getJournalEntries().removeIf(x-> x.getId().equals(id));
            if(removed){
                userServices.saveEntry(user);
                journalEntryRepository.deleteById(id);

            }

        }catch (Exception e){
            System.out.println(e);
            throw  new RuntimeException("An error occurred while delete the entry");
        }
        return removed;

    }


}
