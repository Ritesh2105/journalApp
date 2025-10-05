package com.riteshwebapps.journalApp.repository;

import com.riteshwebapps.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String username);
    User deleteByUserName(String username);
}
