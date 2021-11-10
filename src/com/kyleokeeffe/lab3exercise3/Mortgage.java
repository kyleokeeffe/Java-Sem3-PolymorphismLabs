package com.kyleokeeffe.lab3exercise3;

public abstract class Mortgage implements MortgageConstants {//Abstract class implementing interface
	
	//Class variable for auto-incrementing mortgageNumber instance variable
	private static int mortgageNumberAutoIncrement=1;
	
	//Instance variables
	private int mortgageNumber;
	private String customerName;
	private int amountOfMortgage;
	private int interestRate;
	private int term;
	
	//Constructor
	public Mortgage(int currentInterestRate) {
		this.mortgageNumber = mortgageNumberAutoIncrement++;
		this.setInterestRate(currentInterestRate);
	}
	
	//Getters and Setters
	protected int getMortgageNumber() {
		return mortgageNumber;
	}
	protected String getCustomerName() {
		return customerName;
	}
	
	protected void setCustomerName(String customerName) {
		if(customerName==null) {//validation of user input
			throw new IllegalArgumentException("Customer name cannot be empty. Please enter a customer name.");
		}
		this.customerName = customerName;
	}
	
	protected int getAmountOfMortgage() {
		return amountOfMortgage;
	}
	
	protected void setAmountOfMortgage(int amountOfMortgage) {
		if(amountOfMortgage <=0 || amountOfMortgage > MortgageConstants.MAX_MORTGAGE) {//validation of user input against constant from MortgageConstants interface
			throw new IllegalArgumentException(String.format("Please enter a Mortgage value greater than 0 and less than %d",MortgageConstants.MAX_MORTGAGE));
		}
		this.amountOfMortgage = amountOfMortgage;
	}
	
	protected int getInterestRate() {
		return interestRate;
	}
	
	protected void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}
	
	protected int getTerm() {
		return term;
	}
	
	protected void setTerm(int term) {
		if(term != MortgageConstants.SHORT_TERM && term != MortgageConstants.MEDIUM_TERM && term != MortgageConstants.LONG_TERM)//conditional to set term length to SHORT_TERM if user input is outside constants defined in MortgageConstants interface 
			this.term=MortgageConstants.SHORT_TERM;
		else
			this.term = term;//if user input matches a constant set in MortgageConstants interface, set term to user input
	}
	//Method to display details of subclass instance of superclass
	public String getMortgageInfo() {
		String mortgageType="";
		String report="";
		if(this instanceof BusinessMortgage)//determine if this superclass object is of subclass type BusinessMortgage
			mortgageType = "Business Mortgage";
		else if(this instanceof PersonalMortgage)//determine if this superclass object is of subclass type BusinessMortgage
			mortgageType = "Personal Mortgage";
		//Create String by calling getters for objects
		report +=String.format(""
				+ "Mortgage ID#: %d%n"
				+ "Type: %s%n"
				+ "Customer Name: %s%n"
				+ "Amount: %d%n"
				+ "Interest Rate: %d%n"
				+ "Term: %d%n", this.getMortgageNumber(), mortgageType, this.getCustomerName(), this.getAmountOfMortgage(), this.getInterestRate(), this.getTerm());
			
		return report;
	}
	
}
