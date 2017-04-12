/*
 * Content developed by bwyap (c) 2017 under the MIT license.
 * @author bwyap
 */

package example;

import java.util.Random;
import java.util.Scanner;


/**
 * Guess the number: a simple game that 
 */
public class GuessTheNumber {

	
	private Random random;
	
	private final int LIMIT = 10;
	private int number;
	
	private boolean playing = true;
	
	
	public GuessTheNumber() {
		// Create a new random object
		random = new Random();
	}
	
	
	/**
	 *  Start the game
	 */
	public void start() {

		// Generate a new random number
		number = getNewNumber();
		
		
		// Start the game
		System.out.println("Welcome to Guess The Number!");
		Scanner scan = new Scanner(System.in);
		
		// Game loop 
		while (playing) {
			System.out.print("Guess a number between 0 and " + LIMIT + ": ");
			
			int guess;
			
			try {
				// Get input from the player
				guess = scan.nextInt();
				
				// Player guessed correctly
				if (guess == number) {
					System.out.println("Congratulations! You guessed correctly.");
					System.out.print("Play again? (Y/N) ");
					
					String answer = null;
					boolean accepted = false;
					scan.nextLine();
					
					do {
						answer = scan.nextLine();
						
						// Player wants to play again
						if (answer.equalsIgnoreCase("y")) {
							accepted = true;
							number = getNewNumber();
						}
						
						// Player wants to quit
						else if (answer.equalsIgnoreCase("n")) {
							accepted = true;
							playing = false;
						}
						
						// Invalid input
						else {
							System.out.println("Invalid input! Try again.");
						}
					}
					while (!accepted);
				}
				
				// Player guessed incorrectly
				else {
					System.out.println("Whoops! That's the wrong number. Try again.");
				}
			}
			
			// Invalid input
			catch (Exception e) {
				System.out.println("Invalid input! Try again.");
				scan.nextLine();
			}
		}
		
		// Game finished
		System.out.println("Thanks for playing.");
		scan.close();
	}
	
	
	/**
	 * Generate a new random number between 0 and the limit
	 */
	public int getNewNumber() {
		return random.nextInt(LIMIT);
	}
	
	
	/**
	 * Main method: start the game
	 */
	public static void main(String[] args) {
		new GuessTheNumber().start();
	}
	
}