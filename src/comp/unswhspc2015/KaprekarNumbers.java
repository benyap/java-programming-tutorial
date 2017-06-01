package comp.unswhspc2015;

/**
 * Problem statement at
 * <a href="https://cgi.cse.unsw.edu.au/~progcomp/pop.php?loc=2015opentasks#taskJ">
 * 	https://cgi.cse.unsw.edu.au/~progcomp/pop.php?loc=2015opentasks#taskJ
 * </a>
 * 
 * @author bwyap
 * @since 31 May 2017
 *
 */
public class KaprekarNumbers {
	
	public static void main(String[] args) {
		
		// Print all Kaprekar numbers from 1 to 10000
		for(int i = 1; i < 10000; i++) {
			if (isKaprekar(i)) System.out.println(i);		
		}
		
	}
	
	
	/**
	 * Check if a number is a Kaprekar number
	 * @param num the number to test
	 * @return true if the number is a Kaprekar number
	 */
	static boolean isKaprekar(int num) {
		if (num < 1) return false;
		
		// Convert the number to a string 
		String originalNumberString = num + "";
		
		// Calculate the square
		int square = num * num;
		String squareString = square + "";
		
		// Get the last n digits of the square value
		int n = 0, k = 0;
		n = Integer.parseInt(squareString.substring(squareString.length() - originalNumberString.length()));
		
		// Get the remaining digits
		if (originalNumberString.length() - 1 > 0) {
			k = Integer.parseInt(squareString.substring(0, originalNumberString.length()));
		}
		
		return n + k == num;
	}
	
}
