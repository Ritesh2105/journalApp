//package com.riteshsoftwares.journalApp.controller;
//
//import entity.com.riteshwebapps.journalApp.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryController {
//    private Map<String, JournalEntry> journalEntries = new HashMap<>();
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//    @PostMapping
//    public boolean addJournal(@RequestBody JournalEntry journalEntry){
//        journalEntries.put(journalEntry.getId(),journalEntry);
//        return true;
//    }
//
//    @PutMapping("/id/{myId}")
//    public JournalEntry updateById(@PathVariable String myId, @RequestBody JournalEntry myEntry){
//        return journalEntries.put(myId,myEntry);
//    }
//
//    @DeleteMapping("/id/{myId}")
//    public String deleteById(@PathVariable Long myId){
//         journalEntries.remove(myId);
//        return "Deleted Successfully";
//    }
//
//    @GetMapping("id/{myId}")
//    public JournalEntry getEntryById(@PathVariable Long myId){
//        return journalEntries.get(myId);
//
//    }
//}
