package com.matthewchiborak.dndcharacterserver.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "character")
public class Character {

	@Id
	private String id;
	private String name;
	private int speed;
	private int ac;
	private int proficiencyBonus;
	private boolean strength;
	private boolean constitution;
	private boolean charisma;
	private boolean dexterity;
	private boolean intelligence;
	private boolean wisdom;
	private int currentHP;
	private int maxHP;
	private int strengthScore;
	private int constitutionScore;
	private int charismaScore;
	private int dexterityScore;
	private int intelligenceScore;
	private int wisdomScore;
	private int currentHitDie;
	private int maxHitDie;
	private int currentSlots1;
	private int currentSlots2;
	private int currentSlots3;
	private int currentSlots4;
	private int currentSlots5;
	private int currentSlots6;
	private int currentSlots7;
	private int currentSlots8;
	private int currentSlots9;
	private int maxSlots1;
	private int maxSlots2;
	private int maxSlots3;
	private int maxSlots4;
	private int maxSlots5;
	private int maxSlots6;
	private int maxSlots7;
	private int maxSlots8;
	private int maxSlots9;
	private List<Skill> skills;
	private List<Attack> attacks;
	private List<Counter> counters;
	private List<Reference> references;
	
	public Character() {
		super();
	}

	public Character(String id, String name, int speed, int ac, int proficiencyBonus, boolean strength,
			boolean constitution, boolean charisma, boolean dexterity, boolean intelligence, boolean wisdom,
			int currentHP, int maxHP, int strengthScore, int constitutionScore, int charismaScore, int dexterityScore,
			int intelligenceScore, int wisdomScore, int currentHitDie, int maxHitDie, int currentSlots1,
			int currentSlots2, int currentSlots3, int currentSlots4, int currentSlots5, int currentSlots6,
			int currentSlots7, int currentSlots8, int currentSlots9, int maxSlots1, int maxSlots2, int maxSlots3,
			int maxSlots4, int maxSlots5, int maxSlots6, int maxSlots7, int maxSlots8, int maxSlots9,
			List<Skill> skills, List<Attack> attacks, List<Counter> counters, List<Reference> references) {
		super();
		this.id = id;
		this.name = name;
		this.speed = speed;
		this.ac = ac;
		this.proficiencyBonus = proficiencyBonus;
		this.strength = strength;
		this.constitution = constitution;
		this.charisma = charisma;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.currentHP = currentHP;
		this.maxHP = maxHP;
		this.strengthScore = strengthScore;
		this.constitutionScore = constitutionScore;
		this.charismaScore = charismaScore;
		this.dexterityScore = dexterityScore;
		this.intelligenceScore = intelligenceScore;
		this.wisdomScore = wisdomScore;
		this.currentHitDie = currentHitDie;
		this.maxHitDie = maxHitDie;
		this.currentSlots1 = currentSlots1;
		this.currentSlots2 = currentSlots2;
		this.currentSlots3 = currentSlots3;
		this.currentSlots4 = currentSlots4;
		this.currentSlots5 = currentSlots5;
		this.currentSlots6 = currentSlots6;
		this.currentSlots7 = currentSlots7;
		this.currentSlots8 = currentSlots8;
		this.currentSlots9 = currentSlots9;
		this.maxSlots1 = maxSlots1;
		this.maxSlots2 = maxSlots2;
		this.maxSlots3 = maxSlots3;
		this.maxSlots4 = maxSlots4;
		this.maxSlots5 = maxSlots5;
		this.maxSlots6 = maxSlots6;
		this.maxSlots7 = maxSlots7;
		this.maxSlots8 = maxSlots8;
		this.maxSlots9 = maxSlots9;
		this.skills = skills;
		this.attacks = attacks;
		this.counters = counters;
		this.references = references;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public int getProficiencyBonus() {
		return proficiencyBonus;
	}

	public void setProficiencyBonus(int proficiencyBonus) {
		this.proficiencyBonus = proficiencyBonus;
	}

	public boolean isStrength() {
		return strength;
	}

	public void setStrength(boolean strength) {
		this.strength = strength;
	}

	public boolean isConstitution() {
		return constitution;
	}

	public void setConstitution(boolean constitution) {
		this.constitution = constitution;
	}

	public boolean isCharisma() {
		return charisma;
	}

	public void setCharisma(boolean charisma) {
		this.charisma = charisma;
	}

	public boolean isDexterity() {
		return dexterity;
	}

	public void setDexterity(boolean dexterity) {
		this.dexterity = dexterity;
	}

	public boolean isIntelligence() {
		return intelligence;
	}

	public void setIntelligence(boolean intelligence) {
		this.intelligence = intelligence;
	}

	public boolean isWisdom() {
		return wisdom;
	}

	public void setWisdom(boolean wisdom) {
		this.wisdom = wisdom;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getStrengthScore() {
		return strengthScore;
	}

	public void setStrengthScore(int strengthScore) {
		this.strengthScore = strengthScore;
	}

	public int getConstitutionScore() {
		return constitutionScore;
	}

	public void setConstitutionScore(int constitutionScore) {
		this.constitutionScore = constitutionScore;
	}

	public int getCharismaScore() {
		return charismaScore;
	}

	public void setCharismaScore(int charismaScore) {
		this.charismaScore = charismaScore;
	}

	public int getDexterityScore() {
		return dexterityScore;
	}

	public void setDexterityScore(int dexterityScore) {
		this.dexterityScore = dexterityScore;
	}

	public int getIntelligenceScore() {
		return intelligenceScore;
	}

	public void setIntelligenceScore(int intelligenceScore) {
		this.intelligenceScore = intelligenceScore;
	}

	public int getWisdomScore() {
		return wisdomScore;
	}

	public void setWisdomScore(int wisdomScore) {
		this.wisdomScore = wisdomScore;
	}

	public int getCurrentHitDie() {
		return currentHitDie;
	}

	public void setCurrentHitDie(int currentHitDie) {
		this.currentHitDie = currentHitDie;
	}

	public int getMaxHitDie() {
		return maxHitDie;
	}

	public void setMaxHitDie(int maxHitDie) {
		this.maxHitDie = maxHitDie;
	}

	public int getCurrentSlots1() {
		return currentSlots1;
	}

	public void setCurrentSlots1(int currentSlots1) {
		this.currentSlots1 = currentSlots1;
	}

	public int getCurrentSlots2() {
		return currentSlots2;
	}

	public void setCurrentSlots2(int currentSlots2) {
		this.currentSlots2 = currentSlots2;
	}

	public int getCurrentSlots3() {
		return currentSlots3;
	}

	public void setCurrentSlots3(int currentSlots3) {
		this.currentSlots3 = currentSlots3;
	}

	public int getCurrentSlots4() {
		return currentSlots4;
	}

	public void setCurrentSlots4(int currentSlots4) {
		this.currentSlots4 = currentSlots4;
	}

	public int getCurrentSlots5() {
		return currentSlots5;
	}

	public void setCurrentSlots5(int currentSlots5) {
		this.currentSlots5 = currentSlots5;
	}

	public int getCurrentSlots6() {
		return currentSlots6;
	}

	public void setCurrentSlots6(int currentSlots6) {
		this.currentSlots6 = currentSlots6;
	}

	public int getCurrentSlots7() {
		return currentSlots7;
	}

	public void setCurrentSlots7(int currentSlots7) {
		this.currentSlots7 = currentSlots7;
	}

	public int getCurrentSlots8() {
		return currentSlots8;
	}

	public void setCurrentSlots8(int currentSlots8) {
		this.currentSlots8 = currentSlots8;
	}

	public int getCurrentSlots9() {
		return currentSlots9;
	}

	public void setCurrentSlots9(int currentSlots9) {
		this.currentSlots9 = currentSlots9;
	}

	public int getMaxSlots1() {
		return maxSlots1;
	}

	public void setMaxSlots1(int maxSlots1) {
		this.maxSlots1 = maxSlots1;
	}

	public int getMaxSlots2() {
		return maxSlots2;
	}

	public void setMaxSlots2(int maxSlots2) {
		this.maxSlots2 = maxSlots2;
	}

	public int getMaxSlots3() {
		return maxSlots3;
	}

	public void setMaxSlots3(int maxSlots3) {
		this.maxSlots3 = maxSlots3;
	}

	public int getMaxSlots4() {
		return maxSlots4;
	}

	public void setMaxSlots4(int maxSlots4) {
		this.maxSlots4 = maxSlots4;
	}

	public int getMaxSlots5() {
		return maxSlots5;
	}

	public void setMaxSlots5(int maxSlots5) {
		this.maxSlots5 = maxSlots5;
	}

	public int getMaxSlots6() {
		return maxSlots6;
	}

	public void setMaxSlots6(int maxSlots6) {
		this.maxSlots6 = maxSlots6;
	}

	public int getMaxSlots7() {
		return maxSlots7;
	}

	public void setMaxSlots7(int maxSlots7) {
		this.maxSlots7 = maxSlots7;
	}

	public int getMaxSlots8() {
		return maxSlots8;
	}

	public void setMaxSlots8(int maxSlots8) {
		this.maxSlots8 = maxSlots8;
	}

	public int getMaxSlots9() {
		return maxSlots9;
	}

	public void setMaxSlots9(int maxSlots9) {
		this.maxSlots9 = maxSlots9;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<Attack> getAttacks() {
		return attacks;
	}

	public void setAttacks(List<Attack> attacks) {
		this.attacks = attacks;
	}

	public List<Counter> getCounters() {
		return counters;
	}

	public void setCounters(List<Counter> counters) {
		this.counters = counters;
	}
	
	public List<Reference> getReferences() {
		return references;
	}

	public void setReferences(List<Reference> references) {
		this.references = references;
	}
	
}
