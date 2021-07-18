package com.matthewchiborak.dndcharacterserver.factgenerator.factstrategyfactories;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.matthewchiborak.dndcharacterserver.factgenerator.factstrategies.FactStratI;

public abstract class FactStratFactoryI {

	public abstract FactStratI createStrat(String key) throws IllegalArgumentException, FileNotFoundException;
	
	List<String> getStringsFromFile(String filepath) throws FileNotFoundException {
		
		List<String> results = new ArrayList<String>();
		
		File myObj = new File(filepath);
	    Scanner myReader = new Scanner(myObj);
	    
	    while(myReader.hasNext()) {
	    	results.add(myReader.next());
	    }
		myReader.close();
		
		return results;
	}
}
