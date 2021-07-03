package com.matthewchiborak.dndcharacterserver.model;

public class Attack {

	private String attackRoll;
	private int level;
	private String name;
	private int id;
	private String damageRoll;
	
	public Attack() {
		super();
	}

	public Attack(String attackRoll, int level, String name, int id, String damageRoll) {
		super();
		this.attackRoll = attackRoll;
		this.level = level;
		this.name = name;
		this.id = id;
		this.damageRoll = damageRoll;
	}

	public String getAttackRoll() {
		return attackRoll;
	}

	public void setAttackRoll(String attackRoll) {
		this.attackRoll = attackRoll;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	public String getDamageRoll() {
		return damageRoll;
	}

	public void setDamageRoll(String damageRoll) {
		this.damageRoll = damageRoll;
	}
	
	
}
