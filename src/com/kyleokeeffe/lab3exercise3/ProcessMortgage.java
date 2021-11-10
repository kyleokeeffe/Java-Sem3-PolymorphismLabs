package com.kyleokeeffe.lab3exercise3;

import javax.swing.JOptionPane;

public class ProcessMortgage {

	public static void main(String[] args) {
		
		Mortgage[] mortgageCollection = new Mortgage[3];// Declare and initialize array of 3 superclass objects
		int currentInterestRate=0;
		boolean allMortgagesEntered = false, inputAccepted=false; //Declare and initialize loop repetition and validation booleans
		
		JOptionPane.showMessageDialog(null,String.format("Welcome to the Mortgage Creation Wizard.%nThis wizard will walk you through creating a Mortgage collection.%nPlease click OK to proceed."));
		
		while(!inputAccepted) {//loop for validating user input of currentInterestRate
			try {
				currentInterestRate = Integer.parseInt(JOptionPane.showInputDialog("Before we begin, please enter the current interest rate:"));//Prompt for and save user input 
				inputAccepted=true;
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Please enter a valid interest rate.");
			}
		}
		
		String[] mortgageTypeOptions= {"Business", "Personal"};//string array for button contents definition in dialog box
		JOptionPane.showMessageDialog(null, "We will now start creating the first of three mortgage accounts.");
		
		for(int i = 0;i<mortgageCollection.length;i++) {//loop to alter each item in the mortgage array
			String vocabChoice="";
			switch(i) {//loop to customize user prompt vocabulary based on iteration number
			case 0:
				vocabChoice="first";
				break;
			case 1:
				vocabChoice="next";
				break;
			case 2:
				vocabChoice="last";
				break;
			default:
				break;
			}
			//Dialog prompting user to choose between mortgage subclass types
			int mortgageType = JOptionPane.showOptionDialog(null, String.format("Please select the type for the %s mortgage:",vocabChoice), null, JOptionPane.YES_NO_OPTION , JOptionPane.INFORMATION_MESSAGE, null, mortgageTypeOptions,mortgageTypeOptions[1]);

			Mortgage newMortgage = null; //Declare object of super class
			
			switch(mortgageType) {//loop for determining which button was selected
				case JOptionPane.YES_OPTION:
					newMortgage = new BusinessMortgage(currentInterestRate);//initialize super class object as subclass instance of BusinessMortgage
					break;
				case JOptionPane.NO_OPTION:
					newMortgage = new PersonalMortgage(currentInterestRate);//initialize super class object as subclass instance of PersonalMortgage
					break;
				default:
					break;
			}
			
			inputAccepted=false;//reinitizalise validation boolean
			while(!inputAccepted) {//loop to validate user input
				try {
					newMortgage.setCustomerName(JOptionPane.showInputDialog("Please enter the customer name:"));//Prompt for and save user input by calling object instance variable setter
					inputAccepted=true;
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,"Please enter a valid customer name.");
				}
			}
			
			inputAccepted=false;//reinitizalise validation boolean
			while(!inputAccepted) {//loop to validate user input
				try {
					newMortgage.setAmountOfMortgage(Integer.parseInt(JOptionPane.showInputDialog("Please enter a mortgage amount between 1 and 300000:")));//Prompt for and save user input by calling object instance variable setter
				
					inputAccepted=true;
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,"Please enter a valid mortgage amount.");
				}
			}
			
			inputAccepted=false;//reinitizalise validation boolean
			while(!inputAccepted) {//loop to validate user input
				try {
					newMortgage.setTerm(Integer.parseInt(JOptionPane.showInputDialog("Please enter the length of term for this mortgage:")));//Prompt for and save user input by calling object instance variable setter
					inputAccepted=true;
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,"Please enter a valid length of term.");
				}
			}
			
			mortgageCollection[i]=newMortgage;//save created subclass instance into collection of superclass objects
			//display details from created mortgage object, integrate vocabulary choice into output
			JOptionPane.showMessageDialog(null, String.format("%s mortgage creation completed.%n%nDetails for the created Mortgage:%n%s",vocabChoice.substring(0,1).toUpperCase().concat(vocabChoice.substring(1,vocabChoice.length())) ,newMortgage.getMortgageInfo()));
		}
		String report=String.format("All mortgage accounts created!%nCreated Mortgage details:%n%n");
		for(Mortgage mortgage: mortgageCollection) {//loop to display final report of all created objects
			report+= String.format("%s%n",mortgage.getMortgageInfo());
		}
		JOptionPane.showMessageDialog(null, report);
		JOptionPane.showMessageDialog(null,String.format("Thank you for using the Mortgage Creation Wizard.%n Have a nice day."));
	}
}
