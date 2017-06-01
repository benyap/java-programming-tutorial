package comp.unswhspc2015;

/**
 * Problem statement at
 * <a href="https://cgi.cse.unsw.edu.au/~progcomp/pop.php?loc=2015opentasks#task3">
 * 	https://cgi.cse.unsw.edu.au/~progcomp/pop.php?loc=2015opentasks#task3
 * </a>
 * 
 * @author bwyap
 * @since 31 May 2017
 *
 */
public class Partition {
	
	public static void main(String[] args) {
		run();
	}
	
	
	/**
	 * Set up a list to run the partition algorithm on
	 */
	static void run() {
		// Convert a given string to an array
		int[] list = convertToIntArray("0 1 2 3 2 1 0 -1 -2 -3 -2 -1 0 1 0 1 0");
		
		// Print the initial list
		for(int i : list) { System.out.print(i + " "); }
		System.out.println();
		
		// Run partition algorithm
		partition(list);
		
		// Print the partitioned list
		for(int i : list) { System.out.print(i + " "); }
		System.out.println();
	}
	
	
	/**
	 * Partitions the list into three parts:
	 * negative numbers, zeros and positive numbers.
	 * @param list
	 */
	static void partition(int[] list) {
		// We will use three pointers to represent four partitions of the array
		// (these are our invariants)
		
		// 0 -> lo - 1: hold the negative numbers (partition A)
		// lo -> mid - 1: holds the zeros (partition B)
		// mid -> hi - 1: holds the positive numbers (partition C)
		// hi -> list.length - 1: holds the unsorted numbers (partition D)
		
		int lo = 0;
		int mid = 0;
		int hi = 0;
		
		// Keep iterating until hi == list.length 
		// because we know then we will have no more unsorted numbers
		while(hi < list.length) {
			
			// If our current number is negative,
			// we swap it with a 0 which is at the end of partition A.
			// The next if statement will then take care of the 0.
			// Increase lo to account for the new negative number.
			if (list[hi] < 0) {
				// Swap hi and lo
				int temp = list[lo];
				list[lo] = list[hi];
				list[hi] = temp;
				lo++;
			}
			
			// If our current number is 0,
			// swap it with a positive number which is at the end of partition B.
			// Increase mid to account for the new 0.
			if (list[hi] <= 0) {
				// Swap hi and mid 
				int temp = list[hi];
				list[hi] = list[mid];
				list[mid] = temp;
				mid++;
			}
			
			// list[hi] > 0
			// Current number is positive.
			// (need to increase hi to account for the new positive number)
			
			// We will always increase hi
			hi++;			
		}
	}
	
	
	/**
	 * Convert a string of numbers into integers and put them into an array
	 * @param line
	 * @return
	 */
	static int[] convertToIntArray(String line) {
		String[] numbers = line.split(" ");
		int[] integers = new int[numbers.length];
		
		for(int i = 0; i < integers.length; i++) {
			integers[i] = Integer.parseInt(numbers[i]);
		}
		
		return integers;
	}
	
}
