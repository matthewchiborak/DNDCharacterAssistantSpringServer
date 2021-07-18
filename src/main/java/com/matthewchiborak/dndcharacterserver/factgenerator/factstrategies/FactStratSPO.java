package com.matthewchiborak.dndcharacterserver.factgenerator.factstrategies;

import java.util.List;
import java.util.Random;

public class FactStratSPO extends FactStratI {
	
	List<String> predicates;
	List<String> objects;
	Random rand;
	
	public FactStratSPO(List<String> predicates, List<String> objects) {

		rand = new Random();
		this.predicates = predicates;
		this.objects = objects;
	}

	@Override
	public String createFact(String name) {
		
		return 
		name + " " 
		+ predicates.get(rand.nextInt(predicates.size())) + " " 
		+ objects.get(rand.nextInt(objects.size()));
	}

}
