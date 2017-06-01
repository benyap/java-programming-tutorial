package solutions.exercise09_22052017;

import java.util.Scanner;

/*
Write a program that accepts a string from the user and prints out the reversed string of the input. 
For example, if ‘string’ was entered, the program should output ‘gnirts’.
*/

public class ReverseAString {
	
	public static void main(String[] args) {
		System.out.print("Enter a word: ");
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		
		for(int i = s.length() - 1; i >= 0; i--) {
			System.out.print(s.charAt(i));
		}
		
		in.close();
	}
}
