package com.matthewchiborak.dndcharacterserver.model;

public class Counter {

	private String name;
	private int currentCount;
	private int maxCount;
	private int id;
	
	public Counter() {
		super();
	}

	public Counter(String name, int currentCount, int maxCount, int id) {
		super();
		this.name = name;
		this.currentCount = currentCount;
		this.maxCount = maxCount;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
