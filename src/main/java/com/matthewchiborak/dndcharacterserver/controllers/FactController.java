package com.matthewchiborak.dndcharacterserver.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.matthewchiborak.dndcharacterserver.model.FactRequest;

@RestController
public class FactController {

	private int factCount = 1;
	
	@CrossOrigin
	@PostMapping(value="/fact")
	public ResponseEntity<String> createCharacter(@RequestBody FactRequest factRequest) {
		
			return new ResponseEntity<>("{ \"id\": " + factCount + ", \"text\": \"The " + factRequest.getName() + " is cool\" }", HttpStatus.OK);

	}
}
