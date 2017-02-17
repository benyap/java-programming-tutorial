/*
 * Content developed by bwyap (c) 2017 under the MIT license.
 * @author bwyap
 */

import java.util.Scanner;

public class QuickSort {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] numbers = null;
		boolean success = false;
		
		// Get list size
		while(!success) {
			try {
				System.out.print("QuickSorter - enter the number of elements you wish to sort: ");
				int size = scan.nextInt();
				if (size < 0) throw new Exception();
				success = true;
				numbers = new int[size];
			}
			catch (Exception e) {
				System.out.println("Invalid input.");
				scan.nextLine();
			}
		}
		
		// Get list elements
		for (int i = 0; i < numbers.length;) {
			try {
				System.out.print("Element " + (i + 1) + ": ");
				int value = scan.nextInt();
				numbers[i++] = value;
			}
			catch (Exception e) {
				System.out.println("Invalid input.");
				scan.nextLine();
			}
		}
		
		// Sort the list
		int[] sorted = new QuickSort().sort(numbers);
		
		// Print the sorted list
		System.out.print("Sorted list: ");
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(sorted[i] + " ");
		}
		System.out.println();
	}
	
	
	
	private int[] array;
	
	/**
	 * Sort an input array using quick sort.
	 * @param input an array of integers to sort
	 * @return the sorted array
	 */
	public int[] sort(int[] input) {
		this.array = input;
		
		// Call the recursive quicksort function
		quicksort(0, input.length - 1);
		
		return array;
	}
	
	
	/**
	 * Sort elements in the array between 
	 * the given indexes recursively.
	 * @param lo the beginning index
	 * @param hi the end index
	 */
	private void quicksort(int lo, int hi) {
		// Use the first element as the pivot
		int pivot = lo;
		int pivotValue = array[lo];
		int pos = lo + 1;
		
		// Iterate through the list
		while(pos <= hi) {
			// Move elements lower than the pivot
			if (array[pos] <= pivotValue) {
				array[pivot++] = array[pos];
				array[pos] = array[pivot];
			}			
			pos++;
		}
		array[pivot] = pivotValue;
		
		// Quick sort the partitions
		if (pivot > lo) {
			quicksort(lo, pivot - 1);
		}
		
		if (pivot < hi) {
			quicksort(pivot + 1, hi);
		}
	}
	
}