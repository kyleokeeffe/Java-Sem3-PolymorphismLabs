package com.kyleokeeffe.lab3exercise2;

public class FullTimeGameTester extends GameTester {
	
	private final int baseSalary= 3000;//private constant to define salary of full time tester
	public FullTimeGameTester() {
		super();//call super class constructor
		super.setFullTime(true);//call super class setter for boolean instance variable
	}
	
	//Body definition of abstract method 
	public String determineSalary(GameTester gameTester, int hours) {
		return String.format("Wage Type: Salary%n"
				+ "Salary Amount: $%d",baseSalary);
	}
}
