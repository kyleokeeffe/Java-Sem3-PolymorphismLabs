package com.kyleokeeffe.lab3exercise3;

public class BusinessMortgage extends Mortgage{
	
	public BusinessMortgage(int currentInterestRate) {
		super(currentInterestRate);//call super class constructor
		super.setInterestRate(this.getInterestRate()+2);//call super class getter interest rate, add two, and pass to super class interest rate setter
	}
}
