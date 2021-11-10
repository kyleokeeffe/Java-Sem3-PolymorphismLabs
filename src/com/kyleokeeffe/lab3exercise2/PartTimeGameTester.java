package com.kyleokeeffe.lab3exercise2;

public class PartTimeGameTester extends GameTester{
	private final int baseSalary = 20;//private constant to define salary of part time tester
	public PartTimeGameTester() {
		super();//call super class constructor
		super.setFullTime(false);//call super class setter for boolean instance variable
	}
	//Body definition of abstract method 
	public String determineSalary(GameTester gameTester, int hours){
		
		return String.format("Wage Type: Hourly%n"
				+ "Hourly rate: $%d/hr%n"
				+ "Number of Hours: %d%n"
				+ "Earnings: %d",baseSalary,hours,baseSalary*hours);//perform calculation based on user inputted hours and private constant variable
	}
}
