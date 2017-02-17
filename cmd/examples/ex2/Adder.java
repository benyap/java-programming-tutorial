/*
 * Content developed by bwyap (c) 2017 under the MIT license.
 * @author bwyap
 */

import java.util.Scanner;

public class Adder {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String input = null;
		int sum = 0;
		
		while(true) {
			System.out.print("Enter a number to add (type '=' to calculate the sum): ");
			
			// Read input
			input = scan.nextLine();
			
			if (input.equals("=")) {
				// Print sum and reset
				System.out.println("Sum: " + sum + "\n");
				sum = 0;
			}
			else {
				// Add the to the sum if a valid number was entered
				try {
					float operand = Float.parseFloat(input);
					sum += operand;
				}
				catch (Exception e) {
					System.out.println("Invalid input.");
				}
			}
		}
	}
	
}