package solutions.exercise09_22052017;

import java.util.Scanner;

/*
Write a program that accepts an integer from the user between 0 and 100. 
The program should then try to guess the user’s number. 
How it does that is up to you to implement — see if you can find an algorithm that can always guess the input in 7 guesses or less.
*/

public class GuessTheNumberV2 {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		boolean terminate = false;
		int num = 0;
		
		// Get a number from the user
		while(!terminate) {
			System.out.print("Enter a number between 0 and 100: ");
			try {
				num = in.nextInt();
				// Ensure that the number is within range
				if (num < 0 || num > 100) throw new Exception();
				
				// If there is no exception then we have a valid number from the user and can terminate
				terminate = true;
			}
			catch (Exception e) {
				System.out.println("Invalid number entered.");
				in.nextLine();
			}
		}
		
		// Guess 
		int count = 1;
		int lo = 0;
		int hi = 101;
		int guess = (lo + hi) / 2;
		int result = 0;
		
		// Keep guessing until we get it right
		while((result = evaluateGuess(guess, num)) != 0) {
			count++;
			System.out.println("Guessed " + guess + ": " + (result > 0 ? "too high." : "too low."));
			
			// If the result is too high, we look in the bottom half
			if (result > 0) {
				hi = guess;
			}
			// If the guess was too low, we look in the top half
			else {
				lo = guess;
			}
			
			// Make a guess in the middle of the new search space
			guess = (int)Math.floor((lo + hi) / 2);
		}
		
		System.out.println("Guessed " + guess + ": found the number! (" + num + ")" );
		System.out.println("Found in " + count + " guesses.");
		
		in.close();
	}
	
	
	/**
	 * Check the guess against the answer.
	 * @param guess
	 * @param num
	 * @return 1 if the guess was too high, -1 if the guess was too low, or 0 if the guess was correct.
	 */
	public static int evaluateGuess(int guess, int num) {
		if (guess > num) return 1;
		else if (guess < num) return -1;
		else return 0;
	}
	
}
