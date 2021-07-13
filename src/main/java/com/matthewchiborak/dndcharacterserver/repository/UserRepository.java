package com.matthewchiborak.dndcharacterserver.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.matthewchiborak.dndcharacterserver.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	//@Query(value="{'username': name}", fields="{}")
	User findByUsername(String name);
}
