package com.matthewchiborak.dndcharacterserver.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.matthewchiborak.dndcharacterserver.model.Character;

@Repository
public interface CharacterRepository extends MongoRepository<com.matthewchiborak.dndcharacterserver.model.Character, String> {

	@Query(value="{}", fields="{name:1}")
	List<com.matthewchiborak.dndcharacterserver.model.Character> findCharacterNamesOnly();
}
