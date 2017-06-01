package solutions.exercise09_22052017;

import java.util.Random;
import java.util.Scanner;

/*
Write a program that generates a random number between 0 and 100 and asks the user to guess it. 
If the user guesses too high or too low then the program should output ‘too high’ or ‘too low’ accordingly. 
The program must let the user continue to guess until the user correctly guesses the number. 
Once the user guesses the right number, the program should output ‘Congratulations’ and the number of guesses the user took.
*/

public class GuessTheNumber {
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		
		// Generate a random number
		int num = rand.nextInt(101);
		
		Scanner in = new Scanner(System.in);
		
		int count = 0;
		int guess;
		
		// Get a guess from the user until they get it right
		while((guess = getGuess(in)) != num) {
			count++;
			if (guess > num) {
				System.out.println("Too high");
			}
			else if (guess < num) {
				System.out.println("Too low");
			}
		}
		
		System.out.println("Congratulations! You took " + count + " guesses.");
		
		in.close();
	}
	
	/**
	 * Get a guess from the user using the provided scanner object
	 * @param in
	 * @return
	 */
	static int getGuess(Scanner in) {
		boolean terminate = false;
		int num = 0;
		while(!terminate) {
			System.out.print("Guess a number between 0 and 100: ");
			try {
				num = in.nextInt();
				// if there are no exceptions then we have a valid number from the user and can terminate
				terminate = true;
			}
			catch (Exception e) { }
		}
		return num;
	}
	
}
