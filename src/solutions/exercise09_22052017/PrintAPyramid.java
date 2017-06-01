package solutions.exercise09_22052017;

import java.util.Scanner;

/*
Write a program that accepts an integer between 1 and 30, 
and prints a pyramid made up of asterisks ‘*’ of the specified height. 
For example, if the number 4 was entered, the program should output this:

		   *
		  ***
		 *****
		*******
*/

public class PrintAPyramid {
	
	public static void main(String[] args) {
		
		System.out.print("Enter an integer between 1 and 30: ");
		Scanner in = new Scanner(System.in);
		
		try {
			// Get an integer from the user
			int num = in.nextInt();
			
			if (num > 0 && num <= 30) {
				for(int i = 0; i < num; i++) {
					// Accumulate the required number of spaces
					for(int j = 0; j < (num - i - 1); j++) {
						System.out.print(" ");
					}
					// Accumulate the required number of stars
					for(int j = 0; j < (i*2) + 1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
			}
			else {
				throw new Exception("Please enter an integer between 1 and 30.");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			in.close();			
		}
		
	}
	
}
