package com.SpringBootLearning.SpringBoot.Learning.Repository;

import com.SpringBootLearning.SpringBoot.Learning.Entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
