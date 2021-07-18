package com.matthewchiborak.dndcharacterserver.controllers;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.matthewchiborak.dndcharacterserver.model.FactRequest;

import com.matthewchiborak.dndcharacterserver.factgenerator.FactGenerator;
import com.matthewchiborak.dndcharacterserver.factgenerator.factstrategyfactories.FactStratFactoryI;
import com.matthewchiborak.dndcharacterserver.factgenerator.factstrategyfactories.FactStratFactorySimple;

@RestController
public class FactController {

	private int factCount = 0;
	private FactStratFactoryI factStratFactory = new FactStratFactorySimple("src\\main\\resources\\Predicates.txt", "src\\main\\resources\\Objects.txt");
	private FactGenerator factGenerator = new FactGenerator(factStratFactory);
	
	@CrossOrigin
	@PostMapping(value="/fact")
	public ResponseEntity<String> createCharacter(@RequestBody FactRequest factRequest) {
		
		try {
			factGenerator.changeStrategy("SPO");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		factCount++;
		return new ResponseEntity<>("{ \"id\": " + factCount + ", \"text\": \"" + factGenerator.createFact(factRequest.getName()) + "\" }", HttpStatus.OK);

	}
}
