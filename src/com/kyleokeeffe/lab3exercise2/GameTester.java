package com.kyleokeeffe.lab3exercise2;

public abstract class GameTester {
	//Instance variables
	private String name;
	private boolean isFullTime;
	
	//Getters and setters
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected boolean getFullTime() {
		return isFullTime;
	}

	protected void setFullTime(boolean status) {
		this.isFullTime = status;
	}

	//abstract method for completion by subclasses
	public abstract String determineSalary(GameTester gameTester, int hours);
}
