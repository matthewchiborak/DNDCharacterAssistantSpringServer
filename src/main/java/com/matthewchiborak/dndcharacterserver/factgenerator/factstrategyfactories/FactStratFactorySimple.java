package com.matthewchiborak.dndcharacterserver.factgenerator.factstrategyfactories;

import java.io.FileNotFoundException;
import java.util.List;

import com.matthewchiborak.dndcharacterserver.factgenerator.factstrategies.FactStratI;
import com.matthewchiborak.dndcharacterserver.factgenerator.factstrategies.FactStratSPO;

public class FactStratFactorySimple extends FactStratFactoryI {

	String predicateFilePath;
	String objectFilePath;
	List<String> predicates;
	List<String> objects;
	
	public FactStratFactorySimple(String predicateFilePath, String objectFilePath) {
		
		this.predicateFilePath = predicateFilePath;
		this.objectFilePath = objectFilePath;
		//predicates = getStringsFromFile(predicateFilePath);
		//objects = getStringsFromFile(objectFilePath);
	}
	
	@Override
	public FactStratI createStrat(String key) throws FileNotFoundException {
		
		if(predicates == null || objects == null) {
			predicates = getStringsFromFile(predicateFilePath);
			objects = getStringsFromFile(objectFilePath);
		}
		
		if(key == "SPO")
			return new FactStratSPO(predicates, objects);
		
		throw new IllegalArgumentException();
	}

}
