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

@RestController
public class CharacterController {

	@Autowired
	public CharacterRepository characterRepository;
	
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
	
	@PostMapping(value="/characters")
	public String createCharacter(@RequestBody com.matthewchiborak.dndcharacterserver.model.Character character) {
		com.matthewchiborak.dndcharacterserver.model.Character insertedCharacter = characterRepository.insert(character);
		return "Character created " + insertedCharacter.getName();
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
		
		return new ResponseEntity<>("{\"message\": \"" + newCharacter.getName() + " updated\"}", HttpStatus.OK);
	}
}
