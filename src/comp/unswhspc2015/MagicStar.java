package comp.unswhspc2015;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem statement at
 * <a href="https://cgi.cse.unsw.edu.au/~progcomp/pop.php?loc=2015opentasks#task5">
 * 	https://cgi.cse.unsw.edu.au/~progcomp/pop.php?loc=2015opentasks#task5
 * </a>
 * 
 * @author bwyap
 * @since 31 May 2017
 *
 */
public class MagicStar {
	
	
	/**
	 * Contains the indices in the star representing the 'lines' which we must sum to check if the magic star is valid
	 */
	static int[][] lines = new int[][]{
		{0, 1, 2, 3},
		{3, 4, 5, 6},
		{6, 7, 8, 0},
		{11, 8, 1, 9},
		{9, 2, 4, 10},
		{10, 5, 7, 11}
	};

	
	/**
	 * Contains the indexes of the outer nodes in the star
	 * (represented by the yellow cells in the problem statement)
	 */
	final static int[] outerIndexes = new int[]{
		0, 9, 3, 10, 6, 11	
	};
	
	
	/**
	 * Maps indexes to swap when flipping the star
	 */
	final static int[] flipMapping = new int[]{
		-1, 8, 7, 6, 5,-1,-1,-1,-1,11,-1,-1
	};// 0  1  2  3  4  5  6  7  8  9 10 11

	
	/**
	 * Maps indexes to swap when rotating the star
	 */
	final static int[] rotateMapping = new int[]{
		 0, 1, 9, 2, 3, 4,10, 5, 6, 7,11, 8
	};// 0  1  2  3  4  5  6  7  8  9 10 11
	
	
	/**
	 * Driver method
	 * @param args
	 */
	public static void main(String[] args) {
		// Create an array to store the solutions
		List<List<Integer>> solutions;
		
		// Run the magic star algorithm
		solutions = magicStar(true, 1);
	
		// Print solutions
		for(List<Integer> s : solutions) {
			System.out.println(s);
		}
		
		System.out.println("Found " + solutions.size() + " solution(s).");
	}
	
	
	/**
	 * Generate the magic stars using a backtracking recursive algorithm.
	 * @param superMagicStar determine if the solutions are required to be super magic stars or not.
	 * @param numberOfSolutions the number of solutions that need to be found. If this number is less than 1, it will find all possible solutions.
	 */
	static List<List<Integer>> magicStar(boolean superMagicStar, int numberOfSolutions) {
		
		int order = 6;
		
		// Generate values that our star can use
		List<Integer> values = new LinkedList<Integer>();
		for(int i = 0; i < order*2; i++) {
			values.add(i + 1);
		}
		
		// Create a list to store the star
		List<Integer> star = new LinkedList<Integer>();
		
		// Create a list to store the solutions
		List<List<Integer>> solutions = new ArrayList<List<Integer>>(); 
		
		System.out.println("Generating stars of order " + order + "...");
		System.out.println("Super magic star required: " + superMagicStar);
		
		// Run the backtracking algorithm
		generateStar(star, values, solutions, superMagicStar, numberOfSolutions);
		
		System.out.println("Finished.");
		
		return solutions;
	}
	
	
	/**
	 * Generate a magic star using a backtracking algorithm.
	 * @param star the list that contains a partial solution to the star
	 * @param values the values remaining to be used to construct the star
	 * @param solutions the list of solutions found so far
	 * @param superMagicStar whether the star is required to be a super magic star
	 * @param numberOfSolutions terminate after finding this number of solutions. Use a number less than 1 to find all possible solutions.
	 */
	static void generateStar(List<Integer> star, List<Integer> values, List<List<Integer>> solutions, boolean superMagicStar, int numberOfSolutions) {
		// Stop generating if only required number of solutions has been found
		if (numberOfSolutions > 0 && solutions.size() >= numberOfSolutions) return;
		
		// Base case: the star is complete when it has 12 values 
		if (values.isEmpty() && star.size() == 12) {
			// Check if the solution is valid
			if (isValid(star, 6, superMagicStar)) {
				
				// Complete solution found!
				// Normalize the star
				normalize(star);
				
				// If the normalized result is unique, save it in the solution list
				if (!solutions.contains(star)) {
					solutions.add(new LinkedList<Integer>(star));
				}
			}
		}
		else {
			// Check if the solution is viable and if we should continue testing the solution
			if (isPartialValid(star, 6)) {
				
				int remaining = values.size();
				
				// Try all remaining possibilities
				for(int i = 0; i < remaining; i++) {
					
					// Test a value
					star.add(values.remove(0));
					
					// Recursive call to explore the stars with the added value
					generateStar(star, values, solutions, superMagicStar, numberOfSolutions);
					
					// Backtrack and try another solution 
					// The test value is added back to the end of the list so it won't be used again
					values.add(star.remove(star.size() - 1));
				}
			}
		}
	}
	
	
	/**
	 * Check if a star is partially valid.
	 * It checks all lines that exist within the star and returns false if it exceeds the magic constant.
	 * @param star the (partial) star to validate
	 * @param order the order of the star
	 * @return true if the star is partially valid
	 */
	static boolean isPartialValid(List<Integer> star, int order) {
		int sum = 4*order + 2;

		// Check that each line does not exceed the magic constant
		for(int[] line : lines) {
			int total = 0;
			for(int pos : line) {
				if (pos < star.size()) {
					total += star.get(pos);
				}
				// Star CANNOT be valid if any line exceeds the magic constant
				if (total > sum) return false;					
			}
		}
		
		// Star is potentially valid.
		return true;
	}
	
	
	/**
	 * Checks if a complete magic star is valid.
	 * All lines must add up to the magic constant.
	 * If it is required to be a super magic star, all outer nodes must also add up to the magic constant.
	 * @param star the star to validate
	 * @param order the order of the star
	 * @param superMagicStar whether the star is required to be a magic star
	 * @return true if the star is valid
	 */
	static boolean isValid(List<Integer> star, int order, boolean superMagicStar) {
		final int magicConstant = 4*order + 2;
		
		// Check that each line sums to the magic constant
		for(int[] line : lines) {
			int total = 0;
			// Sum the values of each cell in the line
			for(int pos : line) {
				total += star.get(pos);
				// If at any point the total exceeds the magic constant, it is not valid
				if (total > magicConstant) return false;
			}
			
			// If the total is not equal to the magic constant, it is not valid
			if (total != magicConstant) return false;
		}
		
		// Check for super magic property
		// All outer indexes are summed
		if (superMagicStar) {
			int total = 0;
			for(int index : outerIndexes) {
				total += star.get(index);
				// If at any point the total exceeds the magic constant, it is not valid
				if (total > magicConstant) return false;
			}
			
			// If the total is not equal to the magic constant, it is not valid
			if (total != magicConstant) return false;		
		}
		
		// All constraints satisfied, magic star is valid.
		return true;
	}
	
	
	/**
	 * Normalize the given star by ensuring that:
	 * <ul>
	 * 	<li> the smallest value in the outer nodes is at the top </li>
	 * 	<li> node 8 is greater than node 1 </li>
	 * </ul>
	 * @param star the star to normalize
	 */
	static void normalize(List<Integer> star) {
		// Collect all outer node values into a list
		List<Integer> outer = new ArrayList<Integer>();
		for(int i : outerIndexes) {
			outer.add(star.get(i));
		}
		
		// Get the minimum in the list 
		int min = outer.get(0);
		for(int i : outer) {
			if (i < min) {
				min = i;
			}
		}
		
		// Rotate the star until the minimum is at the top
		while(star.get(0) != min) {
			rotate(star);
		}
		
		// Flip the star if cell 8 is not greater than cell 1
		// TODO hard-coded values
		if (star.get(8) < star.get(1)) flip(star);
	}
	
	
	/**
	 * Rotate the star (twice) according to the provided rotate mapping array.
	 * Each index will be moved to the next position as specified in the array.
	 * @param star the star to rotate
	 */
	static void rotate(List<Integer> star) {
		// Must rotate twice at a time
		for(int z = 0; z < 2; z++) {
			// Remember the first item
			// (it will be replaced by the subsequent shuffles, so we need to remember it and put it back at the end)
			int first = star.get(rotateMapping[0]);
			
			// Shuffle each item along the star according to the indexes in the rotateMapping array
			int prev = rotateMapping[0];
			
			for(int i = 1; i < rotateMapping.length; i++) {
				star.set(prev, star.get(rotateMapping[i]));
				prev = rotateMapping[i];
			}
			
			// Put the first item in the correct position
			star.set(rotateMapping[star.size() - 1], first);
		}
	}	
	
	
	/**
	 * Flip the star according to the provided flip mapping array.
	 * Each value in the flipMapping will be swapped with its index value in the star.
	 * @param star the star to flip
	 */
	static void flip(List<Integer> star) {
		for(int i = 1; i < flipMapping.length; i++) {
			// Each positive index flags that it needs to be swapped
			if (flipMapping[i] > 0) {
				int temp = star.get(i);
				star.set(i, star.get(flipMapping[i]));
				star.set(flipMapping[i], temp);
			}
		}
	}	
	
	
	
	/**
	 * Test a known magic star
	 */
	static void test() {
		// Testing a known valid magic star.
		List<Integer> star = new LinkedList<Integer>();
		star.add(1);	//  0
		star.add(8);	//  1
		star.add(7);	//  2
		star.add(10);	//  3
		star.add(9);	//  4
		star.add(5);	//  5
		star.add(2);	//  6
		star.add(12);	//  7
		star.add(11);	//	8
		star.add(4);	//  9
		star.add(6);	// 10
		star.add(3);	// 11
		System.out.println(isValid(star, 6, true));
	}
}
