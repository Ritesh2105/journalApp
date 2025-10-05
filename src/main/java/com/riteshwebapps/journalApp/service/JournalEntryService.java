package com.riteshwebapps.journalApp.service;

import com.riteshwebapps.journalApp.entity.JournalEntry;
import com.riteshwebapps.journalApp.entity.User;
import com.riteshwebapps.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;
@Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        journalEntry.setDataTime(LocalDateTime.now());
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        User user = userService.findByUserName(userName);
//        user.setUserName(null);
        user.getJournalEntries().add(saved);
        userService.updateJournal(user);
    }
    public void saveEntry(JournalEntry journalEntry){
//        journalEntry.setDataTime(LocalDateTime.now());
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        journalEntryRepository.save(saved);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId objectId){
        return journalEntryRepository.findById(objectId);
    }
   @Transactional
    public boolean deleteById(ObjectId objectId,String userName){
    boolean removed = false;
        try {
            User user = userService.findByUserName(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(objectId));
            if (removed) {
                userService.saveEntry(user);
                journalEntryRepository.deleteById(objectId);
            }
            return removed;
        }
        catch(Exception e){
            System.out.println(e);
            throw new RuntimeException("An error occurred while deleting the entry",e);
        }
    }
}
