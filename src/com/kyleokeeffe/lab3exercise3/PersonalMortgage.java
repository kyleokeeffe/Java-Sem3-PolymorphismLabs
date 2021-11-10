package com.kyleokeeffe.lab3exercise3;

public class PersonalMortgage extends Mortgage{
	//Constructor
	public PersonalMortgage(int currentInterestRate) {
		super(currentInterestRate);//call super class constructor
		super.setInterestRate(this.getInterestRate()+2);//call super class getter interest rate, add two, and pass to super class interest rate setter
	}
}
