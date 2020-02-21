package com.epam.clean_code;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner scanner = new Scanner(System.in);
        System.out.println("Calculate: \n\t1.Simple Interest or Compound Interest\n\t2.House Construction Cost Estimation");
        System.out.println("Choose an option (1/2)");
        int operationChoice = scanner.nextInt();
        if(operationChoice == 1) {
        	getInterestParameters(scanner);
        } else if(operationChoice == 2) {
        	getHouseDetails(scanner);
        } else {
        	scanner.close();
        	return;
        }   
        scanner.close();
    }
    private static void getHouseDetails(Scanner scanner) {
    	try {
    		String materialType;
    		boolean fullyAutomated = false;
        	System.out.println("Total Area for the house");
        	float totalArea = scanner.nextFloat();
        	System.out.println("Select material type : \n\t1.standard\n\t2.above standard\n\t3.high standard\n\t4.high standard and fully automated)");
        	int materialChoice = scanner.nextInt();
        	if(materialChoice == 1)
        		materialType = "standard";
        	else if(materialChoice == 2)
        		materialType = "aboveStandard";
        	else if(materialChoice == 3) {
        		materialType = "highStandard";
        		System.out.println("Do you want a fully automated house (y/n)");
        		char automationChoice = scanner.next().charAt(0);
        		if(automationChoice == 'Y' || automationChoice == 'y') {
        			fullyAutomated = true;
        		}
        	}
        		
        	else if(materialChoice == 4) { 
        		materialType = "highStandardFullyAutomated";
        	}
        	else
        		return;
        	calculateHouseConstructionCost( totalArea,  materialType, fullyAutomated);
    	} catch(Exception exception) {
    		exception.printStackTrace();
    	} finally {
    		scanner.close();
    	}
    	
	}
	private static void calculateHouseConstructionCost(float totalArea, String materialType, boolean fullyAutomated) {
    	House house = new House(totalArea, materialType, fullyAutomated);
    	System.out.println("Total Price of the house would be " + house.getHousePrice());
	}
    
	private static void getInterestParameters(Scanner scanner) {
		try {
			int compoundingTime = 0;
			System.out.println("What do you want to calculate?  \n\t1.Simple Interest\n\t2.Compound Interest");
			int interestChoice = scanner.nextInt();
			
			System.out.println("Input principal amount");
			float principalAmount = scanner.nextFloat();
			
			System.out.println("Input interest rate");
			float interestRate = scanner.nextFloat();
			
			System.out.println("Input total time (in years)");
			int totalTime = scanner.nextInt();
			
			if(interestChoice == 2) {
				System.out.println("Enter compounding time");
				compoundingTime = scanner.nextInt();
			}	
			calculateInterest(principalAmount, interestRate, totalTime, compoundingTime);
		} catch(Exception exception) {
			exception.printStackTrace();
		}	finally {
			scanner.close();
		}
	}
	private static void calculateInterest(float principal,float interestRate,int totalTime,int compoundingTime) {
    	Interest interest;
    	float interestAmount;
		if(compoundingTime == 0) {
    		interest = new Interest(interestRate, principal, totalTime); 
    		interestAmount = interest.calculateSimpleInterest();
    	} else {
    		interest = new Interest(interestRate, principal, totalTime, compoundingTime);
    		interestAmount = interest.calculateCompoundInterest();
    	}
		System.out.println("Interest amount is " + interestAmount);
    }
}
