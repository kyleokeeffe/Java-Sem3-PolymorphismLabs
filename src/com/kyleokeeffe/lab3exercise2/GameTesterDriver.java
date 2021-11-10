package com.kyleokeeffe.lab3exercise2;

import java.util.Scanner;

public class GameTesterDriver {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		GameTester gameTester1 = null;//Declare instance of superclass without initializing it
		int numberOfHours = 0;
		boolean typeSelectionDone=false, hoursInputDone=false, creatingAllTestersDone=false, createAnotherTesterInputDone=false; //validation and repeated entry boolean variables declarations
		
		while(!creatingAllTestersDone) {//Loop to allow creating multiple tester accounts
			
			System.out.printf("Please choose the type of GameTester to create. Please enter 1 or 2:%n1) Full Time Game Tester%n2) Part Time Game Tester%n");//prompt user for input
			
			int testerTypeInput=input.nextInt();//save user input 
			typeSelectionDone=false; 
			
			while(!typeSelectionDone) {//Loop for validation of tester type input
				
				if(testerTypeInput == 1 || testerTypeInput == 2) {
					if(testerTypeInput==1)
						gameTester1 = new FullTimeGameTester();//initialize superclass object as subclass instance
					else {
						gameTester1 = new PartTimeGameTester();//initialize superclass object as subclsss instance
						System.out.printf("Please enter number of hours for Part Time Game Tester:%n");//Prompt user to input number of part time hours 
						
						while(!hoursInputDone) {//Loop for validation of Part-time hours input

							try{
								numberOfHours = input.nextInt();//save user input
								hoursInputDone=true;
							}
							catch(Exception e) {
								System.out.println("Please enter a valid number of hours");
							}
						}	
					}
					typeSelectionDone = true;
				}
				else 
					System.out.println("Please enter a valid selection (ie. 1, or 2)");
			}
			
			String gameTester1Status = gameTester1.getFullTime() ? "Full-time": "Part-time";//Conditional for determining string to display based on boolean instance variable
			System.out.printf("Tester Status: %s%n%s%n",gameTester1Status, gameTester1.determineSalary(gameTester1, numberOfHours));//display created subclass object, polymorphically call determineSalary method
			System.out.println("Would you like to add a new Game Tester? Please enter Y or N");//prompt user for exit or create another object
			
			createAnotherTesterInputDone = false;
			
			while(!createAnotherTesterInputDone) {//Loop for validation of user input for deciding if more accounts need creating
				String createAnotherTesterInput = input.next().toUpperCase();//save user input
				if(createAnotherTesterInput.equals("Y") || createAnotherTesterInput.equals("YES") || createAnotherTesterInput.equals("N") || createAnotherTesterInput.equals("NO")) {
					createAnotherTesterInputDone=true;
					if(createAnotherTesterInput.equals("Y") || createAnotherTesterInput.equals("YES")) {
						creatingAllTestersDone=false;
					}
					else {
						creatingAllTestersDone=true;
						System.out.println("Thank you! Have a nice day!");//display exit message
					}
				}
				else 
					System.out.println("Please enter a valid selection (ie. 1 or 2");
			}	
		}
	}
}
