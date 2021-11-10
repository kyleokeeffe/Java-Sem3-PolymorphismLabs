package com.kyleokeeffe.comp228lab3;

public abstract class Insurance {
	//Instance variables for superclass
	private String insuranceType;
	private double monthlyCost;
	
	//Getters and setters
	protected void setInsuranceType(String insuranceType) {
		this.insuranceType=insuranceType;
	}
	
	protected String getInsuranceType() {
		return this.insuranceType;
	}
	
	protected void setMonthlyCost(double monthlyCost) {
		this.monthlyCost=monthlyCost;
	}
	
	protected double getMonthlyCost() {
		return this.monthlyCost;
	}
	
	//Abstract methods for body declaration by subclasses
	public abstract void setInsuranceCost(int insuranceCost); 
	
	public abstract String displayInfo(); 
}
