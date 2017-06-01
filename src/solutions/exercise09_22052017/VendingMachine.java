package solutions.exercise09_22052017;

import java.util.Scanner;

/*
Make a simple Vending Machine that allows the user to select what type of beverage they want. 
The program should prompt the user to enter an integer between 1 and 5, 
then print the selected beverage name once the user presses enter. 
If the user enters an integer not between 1 and 5, the program should output ‘Invalid choice’.
*/

public class VendingMachine {
	
	public static void main(String[] args) {
		
		System.out.print("Enter a choice (between 1 and 5): ");
		
		Scanner in = new Scanner(System.in);
		
		try {
			int num = in.nextInt();
			
			if (num >= 1 && num <= 5) {
				switch(num) {
				case 1: System.out.println("Coke"); break;
				case 2: System.out.println("Lift"); break;
				case 3: System.out.println("Fanta"); break;
				case 4: System.out.println("Sprite"); break;
				case 5: System.out.println("Mountain Dew"); break;
				}
			}
			else throw new Exception();
		}
		catch (Exception e) {
			System.err.println("Invalid choice entered.");
		}
		finally {
			in.close();			
		}
	}
	
}
