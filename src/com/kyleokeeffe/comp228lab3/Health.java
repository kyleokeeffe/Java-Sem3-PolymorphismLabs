package com.kyleokeeffe.comp228lab3;

public class Health extends Insurance{//Subclass of superclass Insurance

	public Health() {
		super();//call parent constructor
		this.setInsuranceType("Health");//initialize insurance type to subclass name
	}
	//Body declaration of abstract methods	
	public void setInsuranceCost(int insuranceCost) {
		super.setMonthlyCost(insuranceCost);//call super setter method to change insurance cost
	}
	
	public String displayInfo() {
		//Create output string by calling superclass getter methods 
		return String.format("Insurance Type: %s%n    Monthly Cost: %s",super.getInsuranceType(),Double.toString(super.getMonthlyCost()));
	}
}
