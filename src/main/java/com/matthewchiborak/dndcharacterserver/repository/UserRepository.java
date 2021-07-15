package com.matthewchiborak.dndcharacterserver.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.matthewchiborak.dndcharacterserver.model.User;
import com.matthewchiborak.dndcharacterserver.model.Userdb;

public interface UserRepository extends MongoRepository<Userdb, String> {

	Userdb findByUsername(String name);
}
