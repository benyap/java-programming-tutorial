package solutions.exercise09_22052017;

import java.util.Scanner;

/*
Write a program that accepts a string from the user and checks if it is a palindrome, 
outputting ‘true’ if it is, and ‘false’ otherwise. 
(A palindrome is a word that reads the same forward and backward, such as ‘racecar’.)
 */

public class PalindromeCheck {

	public static void main(String[] args) {
		System.out.print("Enter a word: ");
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		
		for(int i = 0; i< s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				System.out.println("false");
				in.close();
				return;
			}
		}
		
		System.out.println("true");
		
		in.close();
	}

}
