package com.kyleokeeffe.comp228lab3;

public class Life extends Insurance{//Subclass of superclass Insurance
	
	public Life() {
		super();//call parent constructor
		this.setInsuranceType("Life");//initialize insurance type to subclass name
	}
	//Body declaration of abstract methods	
	public void setInsuranceCost(int insuranceCost) {
		this.setMonthlyCost(insuranceCost);//call super setter method to change insurance cost
	}
	
	public String displayInfo() {
		return String.format("Insurance Type: %s%n    Monthly Cost: %s",super.getInsuranceType(),Double.toString(super.getMonthlyCost()));//return formatted string which uses get accessors from parent
	}
}
