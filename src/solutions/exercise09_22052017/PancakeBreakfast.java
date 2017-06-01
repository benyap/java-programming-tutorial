package solutions.exercise09_22052017;

import java.util.Scanner;

/*
Write a program that asks the user to enter the number of pancakes eaten for 
breakfast by 10 different people (Person 1, Person 2, ..., etc). 
Once the data has been entered the program must analyse the data and output 
the order of number of pancakes eaten of all 10 people.
*/

public class PancakeBreakfast {
	
	static final int NUM_PEOPLE = 10;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		Person[] people = new Person[NUM_PEOPLE];  
		
		// Create 10 people and get the number of pancakes they ate from the user
		for(int i = 0; i < people.length; i++) {
			System.out.println("Person " + (i + 1) + " - ");
			people[i] = new Person(i + 1, getNum(in));
		}
		
		// Sort the people
		sort(people);
		
		// Print the result
		for(int i = 0; i < people.length; i++) {
			System.out.println("Person " + people[i].id + " ate " + people[i].pancakes + " pancakes.");
		}
		
		in.close();
	}
	
	
	/**
	 * Sort the array of people according to the pancakes they ate
	 * @param people
	 */
	static void sort(Person[] people) {
		// Insertion sort
		for(int i = 1; i < people.length; i++) {
			int index = i;
			while(index > 0 && people[index].pancakes < people[index - 1].pancakes) {
				Person temp = people[index];
				people[index] = people[index - 1];
				people[index - 1] = temp;
				index--;
			}
		}
	}
	
	
	/**
	 * Get a number from the user using the provided scanner object
	 * @param in
	 * @return
	 */
	static int getNum(Scanner in) {
		boolean terminate = false;
		int num = 0;
		while(!terminate) {
			System.out.print("Enter pancakes eaten: ");
			try {
				num = in.nextInt();
				if (num >= 0) {
					terminate = true;
				}
				else throw new Exception();
			}
			catch (Exception e) {
				System.out.println("Invalid value given. Try again.");
				in.nextLine();
			}
		}
		return num;
	}
	
	
	/**
	 * A person contains an ID and the number of pancakes they ate
	 * @author bwyap
	 *
	 */
	static class Person {
		final int id;
		final int pancakes;
		
		Person(int id, int pancakes) {
			this.id = id;
			this.pancakes = pancakes;
		}
	}
	
}
