//package com.riteshsoftwares.journalApp.controller;
//
//import entity.com.riteshwebapps.journalApp.JournalEntry;
//import service.com.riteshwebapps.journalApp.JournalEntryService;
//import org.apache.coyote.Response;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.*;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryControllerV2 {
//    @Autowired
//    private JournalEntryService journalEntryService;
//
//    @GetMapping
//    public List<JournalEntry>  getAll(){
//        return journalEntryService.getAll();
//    }
//    @PostMapping
//    public boolean addJournal(@RequestBody JournalEntry journalEntry){
//        journalEntry.setDataTime(LocalDateTime.now());
//        journalEntryService.saveEntry(journalEntry);
//        return true;
//    }
//
//    @PutMapping("/id/{myId}")
//    public JournalEntry updateById(@PathVariable ObjectId myId, @RequestBody JournalEntry myEntry){
//        JournalEntry old = journalEntryService.findById(myId).orElse(null);
//        if(old !=null){
//            old.setTitle(myEntry.getTitle()!=null && !myEntry.getTitle().equals("") ? myEntry.getTitle() : old.getTitle());
//            old.setContent(myEntry.getContent()!=null && !myEntry.getContent().equals("") ? myEntry.getContent() :old.getContent());
//            journalEntryService.saveEntry(old);
//        }
//        return old;
//    }
//
//    @DeleteMapping("/id/{myId}")
//    public ResponseEntity deleteById(@PathVariable ObjectId myId){
//        try {
//            journalEntryService.deleteById(myId);
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        catch (Exception e){
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("id/{myId}")
//    public ResponseEntity<JournalEntry> getEntryById(@PathVariable ObjectId myId){
//        Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
//        if(journalEntry.isPresent()){
//            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
////        return journalEntry.map(entry -> new ResponseEntity<>(entry, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//
//    }
//}
