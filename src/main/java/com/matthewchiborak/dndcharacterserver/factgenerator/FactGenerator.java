package com.matthewchiborak.dndcharacterserver.factgenerator;

import java.io.FileNotFoundException;

import com.matthewchiborak.dndcharacterserver.factgenerator.factstrategies.FactStratI;
import com.matthewchiborak.dndcharacterserver.factgenerator.factstrategyfactories.FactStratFactoryI;

public class FactGenerator {

	FactStratFactoryI stratFact;
	FactStratI strategy;
	
	public FactGenerator(FactStratFactoryI stratFact) {
		this.stratFact = stratFact;
	}
	
	public void changeStrategy(String stratKey) throws IllegalArgumentException, FileNotFoundException {
		strategy = stratFact.createStrat(stratKey);
	}
	
	public String createFact(String name) {
		return strategy.createFact(name);
	}
}
