package com.kyleokeeffe.comp228lab3;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class InsuranceDriver {

	public static void main(String[] args)throws Exception {
		ArrayList<Insurance> insuranceCollection = new ArrayList<Insurance>();//Declare and initialize collection of super class type
		String[] insuranceTypeOptions= {"Health", "Life"};//array of button content choices for insuranceType dialog
		String[] exitOptions= {"Exit", "Edit Costs"};//array of button content choices for exit dialog

		int continueAddingAccounts=JOptionPane.YES_OPTION;
		
		//Loop to allow multiple accounts to be added
		while(continueAddingAccounts==JOptionPane.YES_OPTION) {
			//Button choice dialog to prompt and receive input for selection of subclass type
			int insuranceType = JOptionPane.showOptionDialog(null, "Please select the type of insurance:", null, JOptionPane.YES_NO_OPTION , JOptionPane.INFORMATION_MESSAGE, null, insuranceTypeOptions,insuranceTypeOptions[1]);
			Insurance newInsurance = null;//create uninitialized superclass object
			
			//Switch to determine which button was pressed in insuranceType dialog
			switch(insuranceType) {
				case JOptionPane.YES_OPTION:
					//initialize super class object as instance of Health subclass
					newInsurance = new Health();
					newInsurance.setInsuranceType("Health");
					break;
				case JOptionPane.NO_OPTION:
					//initialize super class object as instance of Health subclass
					newInsurance = new Life();
					newInsurance.setInsuranceType("Life");
					break;
				default:
					break;
			}
			
			double monthlyFeeInput=Double.valueOf(JOptionPane.showInputDialog("Please enter the monthly fee for this insurance:"));//prompt and receive input for monthly fee
			newInsurance.setMonthlyCost(monthlyFeeInput);//set monthly fee to instance variable of insurance object
			insuranceCollection.add(newInsurance);//add insurance object to collection of insurance 
			continueAddingAccounts = JOptionPane.showConfirmDialog(null,"Would you like to add another Insurance policy?",null,JOptionPane.YES_NO_OPTION);//decision dialog to loop back to create another account or not
		}
		String insuranceReport = String.format("Current Insurance Polices:%n"); //declare and initialize report output string 
		int policyIndex=1;
		for(Insurance insurance:insuranceCollection){//loop through collection of insurance accounts for creating report output string 
			insuranceReport+=String.format("%d) %s%n",policyIndex, insurance.displayInfo());//polymorphically call displayInfo method
			policyIndex++;
		}
		
		
		int exitOption = JOptionPane.showOptionDialog(null, insuranceReport, null, JOptionPane.YES_NO_OPTION , JOptionPane.INFORMATION_MESSAGE, null, exitOptions,null);//Decision dialog to choose to exit or not

			
		switch(exitOption) {//switch for determining whether exit was chosen or not
			case JOptionPane.YES_OPTION://exit option
				JOptionPane.showMessageDialog(null, "Thank you! Have a nice day!");
				break;
			case JOptionPane.NO_OPTION://edit option
				
				int newMonthlyFee=0;
				boolean goodInput=false;//declare and initialize validation variable for new monthly fee input
				for(Insurance insurance:insuranceCollection){//loop for going through insurance account collection and changing monthly ammounts 
					goodInput=false;//reinitialize validation variable
					while(!goodInput) {//loop to allow validation of input for newMonthlyFee 
				

						try {
							//display each insurance account,  prompt user to change monthly fee, save user input in variable
							newMonthlyFee = Integer.parseInt(JOptionPane.showInputDialog(String.format("Please enter a new monthly fee for the following Account:%n%s%n",insurance.displayInfo())));
							goodInput = true;
							insurance.setInsuranceCost(newMonthlyFee);//polymorphically call setInsuranceCost method to save new monthly fee input 
						}
						catch(NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Please enter a valid monthly amount.");
						}
					}
					

					
				}
				break;
			default:
				break;
		}
		
		
		
		
		
		
		insuranceReport = String.format("Current Insurance Polices:%n"); //reinitialize report string following monthly fee edits
		policyIndex=1;
		for(Insurance insurance:insuranceCollection){//loop to rewrite report output string
			insuranceReport+=String.format("%d) %s%n",policyIndex, insurance.displayInfo());
			policyIndex++;
		}
		JOptionPane.showMessageDialog(null, String.format(insuranceReport, args));//display final output string
	}
}

