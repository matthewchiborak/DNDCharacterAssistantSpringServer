package com.matthewchiborak.dndcharacterserver.controllers;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.matthewchiborak.dndcharacterserver.model.Character;
import com.matthewchiborak.dndcharacterserver.repository.CharacterRepository;

import com.matthewchiborak.dndcharacterserver.model.User;
import com.matthewchiborak.dndcharacterserver.model.Login;

@RestController
public class CharacterController {

	@Autowired
	public CharacterRepository characterRepository;
	
	@CrossOrigin
	@PostMapping(value="/users/authenticate")
	public ResponseEntity<User> authenticateUser(@RequestBody Login login) {
		
			System.out.println("Got Login: " + login.getUsername() + " " + login.getPassword());

			User dummyUser = new User(1, "Admin", "Password", "WhatGoesHere");
			
			if(login.getUsername().equals("a") && login.getPassword().equals("a"))
				return new ResponseEntity<>(dummyUser, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	@CrossOrigin
	@GetMapping(value="/characters")
	public ResponseEntity<List<com.matthewchiborak.dndcharacterserver.model.Character>> getAllCharacters() {		
		List<com.matthewchiborak.dndcharacterserver.model.Character> allChars = characterRepository.findCharacterNamesOnly();
		
		if(allChars.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(allChars, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/characters/{id}")
	public ResponseEntity<com.matthewchiborak.dndcharacterserver.model.Character> getSpecificCharacter(@PathVariable("id") String id) {
		Optional<com.matthewchiborak.dndcharacterserver.model.Character> charData = characterRepository.findById(id);
		
		if(charData.isPresent()) {
			return new ResponseEntity<>(charData.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin
	@PostMapping(value="/characters")
	public ResponseEntity<String> createCharacter(@RequestBody com.matthewchiborak.dndcharacterserver.model.Character character) {
		com.matthewchiborak.dndcharacterserver.model.Character insertedCharacter = characterRepository.insert(character);
		
		if(insertedCharacter != null)
			return new ResponseEntity<>("{\"message\": \"" + insertedCharacter.getName() + " created successfully\"}", HttpStatus.OK);
		else
			return new ResponseEntity<>("{\"message\": \"Character Creation Failed\"}", HttpStatus.BAD_REQUEST);
	}
	
	@CrossOrigin
	@PutMapping("/characters")
	public <U> ResponseEntity<String> updateCharacter(@RequestBody com.matthewchiborak.dndcharacterserver.model.Character newCharacter) {
		
		Optional<com.matthewchiborak.dndcharacterserver.model.Character> charData = characterRepository.findById(newCharacter.getId());
		
		if(!charData.isPresent())
			return new ResponseEntity<>("{\"message\": \"Failed to update\"}", HttpStatus.NOT_FOUND);
		
		characterRepository.findById(newCharacter.getId()).map((Function<? super Character, ? extends U>) character -> {
			character.setCurrentHP(newCharacter.getCurrentHP());
			character.setCurrentHitDie(newCharacter.getCurrentHitDie());
			character.setCurrentSlots1(newCharacter.getCurrentSlots1());
			character.setCurrentSlots2(newCharacter.getCurrentSlots2());
			character.setCurrentSlots3(newCharacter.getCurrentSlots3());
			character.setCurrentSlots4(newCharacter.getCurrentSlots4());
			character.setCurrentSlots5(newCharacter.getCurrentSlots5());
			character.setCurrentSlots6(newCharacter.getCurrentSlots6());
			character.setCurrentSlots7(newCharacter.getCurrentSlots7());
			character.setCurrentSlots8(newCharacter.getCurrentSlots8());
			character.setCurrentSlots9(newCharacter.getCurrentSlots9());
			character.setCounters(newCharacter.getCounters());
			characterRepository.save(character);
			return null;
		});
		
		return new ResponseEntity<>("{\"message\": \"" + newCharacter.getName() + " updated successfully\"}", HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/charactersstats")
	public <U> ResponseEntity<String> updateCharacterStats(@RequestBody com.matthewchiborak.dndcharacterserver.model.Character newCharacter) {
		
		Optional<com.matthewchiborak.dndcharacterserver.model.Character> charData = characterRepository.findById(newCharacter.getId());
		
		if(!charData.isPresent())
			return new ResponseEntity<>("{\"message\": \"Failed to update\"}", HttpStatus.NOT_FOUND);
		
		characterRepository.findById(newCharacter.getId()).map((Function<? super Character, ? extends U>) character -> {
			character.setName(newCharacter.getName());
			character.setSpeed(newCharacter.getSpeed());
			character.setAc(newCharacter.getAc());
			character.setProficiencyBonus(newCharacter.getProficiencyBonus());
			character.setStrength(newCharacter.isStrength());
			character.setConstitution(newCharacter.isConstitution());
			character.setCharisma(newCharacter.isCharisma());
			character.setDexterity(newCharacter.isDexterity());
			character.setIntelligence(newCharacter.isIntelligence());
			character.setWisdom(newCharacter.isWisdom());
			character.setCurrentHP(newCharacter.getCurrentHP());
			character.setMaxHP(newCharacter.getMaxHP());
			character.setStrengthScore(newCharacter.getStrengthScore());
			character.setConstitutionScore(newCharacter.getConstitutionScore());
			character.setCharismaScore(newCharacter.getCharismaScore());
			character.setDexterityScore(newCharacter.getDexterityScore());
			character.setIntelligenceScore(newCharacter.getIntelligenceScore());
			character.setWisdomScore(newCharacter.getWisdomScore());
			character.setCurrentHitDie(newCharacter.getCurrentHitDie());
			character.setMaxHitDie(newCharacter.getMaxHitDie());
			character.setHitDieDice(newCharacter.getHitDieDice());
			character.setCurrentSlots1(newCharacter.getCurrentSlots1());
			character.setCurrentSlots2(newCharacter.getCurrentSlots2());
			character.setCurrentSlots3(newCharacter.getCurrentSlots3());
			character.setCurrentSlots4(newCharacter.getCurrentSlots4());
			character.setCurrentSlots5(newCharacter.getCurrentSlots5());
			character.setCurrentSlots6(newCharacter.getCurrentSlots6());
			character.setCurrentSlots7(newCharacter.getCurrentSlots7());
			character.setCurrentSlots8(newCharacter.getCurrentSlots8());
			character.setCurrentSlots9(newCharacter.getCurrentSlots9());
			character.setMaxSlots1(newCharacter.getMaxSlots1());
			character.setMaxSlots2(newCharacter.getMaxSlots2());
			character.setMaxSlots3(newCharacter.getMaxSlots3());
			character.setMaxSlots4(newCharacter.getMaxSlots4());
			character.setMaxSlots5(newCharacter.getMaxSlots5());
			character.setMaxSlots6(newCharacter.getMaxSlots6());
			character.setMaxSlots7(newCharacter.getMaxSlots7());
			character.setMaxSlots8(newCharacter.getMaxSlots8());
			character.setMaxSlots9(newCharacter.getMaxSlots9());
			character.setSkills(newCharacter.getSkills());
			character.setAttacks(newCharacter.getAttacks());
			character.setCounters(newCharacter.getCounters());
			character.setReferences(newCharacter.getReferences());
			characterRepository.save(character);
			return null;
		}); 
		
		return new ResponseEntity<>("{\"message\": \"" + newCharacter.getName() + " updated successfully\"}", HttpStatus.OK);
	}
}
