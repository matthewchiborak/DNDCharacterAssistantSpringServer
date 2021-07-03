package com.matthewchiborak.dndcharacterserver.model;

public class Skill {
	
	private String skill;
	private String name;
	private int id;
	private boolean proficient;
	
	public Skill() {
		super();
	}

	public Skill(String skill, String name, int id, boolean proficient) {
		super();
		this.skill = skill;
		this.name = name;
		this.id = id;
		this.proficient = proficient;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isProficient() {
		return proficient;
	}

	public void setProficient(boolean proficient) {
		this.proficient = proficient;
	}
	
	
	
}
