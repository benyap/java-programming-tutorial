/*
 * Content developed by bwyap (c) 2017 under the MIT license.
 * @author bwyap
 */

import java.util.Scanner;

public class MergeSort {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] numbers = null;
		boolean success = false;
		
		// Get list size
		while(!success) {
			try {
				System.out.print("MergeSorter - enter the number of elements you wish to sort: ");
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
		int[] sorted = new MergeSort().sort(numbers);
		
		// Print the sorted list
		System.out.print("Sorted list: ");
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(sorted[i] + " ");
		}
		System.out.println();
	}
	
	
	
	private int[] array;
	private int[] aux;
	
	/**
	 * Sort a list given using merge sort.
	 * @param input an array of integers to sort
	 * @return the sorted list
	 */
	public int[] sort(int[] input) {
		this.array = input;
		this.aux = new int[input.length];
		
		// Call the recursive mergesort function
		mergesort(0, input.length - 1);
		
		return array;
	}
	
	
	/**
	 * Sort the numbers in the array between 
	 * the given indexes recursively.
	 * @param lo the beginning index
	 * @param hi the end index
	 */
	private void mergesort(int lo, int hi) {
		if (lo < hi) {
			int mid = lo + (hi - lo)/2;
			
			// Recursively sort two halves
			mergesort(lo, mid);
			mergesort(mid + 1, hi);
			
			// Merge the sorted parts
			merge(lo, mid, hi);
		}		
	}
	
	
	/**
	 * Merge the two partitions indicated
	 * by the given indexes.
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	private void merge(int lo, int mid, int hi) {
		// Copy the array into aux
		for (int i = lo; i <= hi; i++) {
			aux[i] = array[i];
		}
		
		int i = lo;
		int j = mid + 1;
		int k = lo;
		
		// Move the lower of other element of the 
		//two partitions into the array
		while(i <= mid && j <= hi) {
			if (aux[i] <= aux[j]) {
				array[k++] = aux[i++];
			}
			else {
				array[k++] = aux[j++];
			}
		}
		
		// Move any leftover elements into the array
		while (i <= mid) {
			array[k++] = aux[i++];
		}
		
		while (j <= hi) {
			array[k++] = aux[j++];
		}
	}
}