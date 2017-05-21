package sorting;

public class QuickSort extends IntegerArraySorter {

	private int[] array;

	@Override
	public int[] sort(int[] list) {
		
		this.array = list;
		
		// Call the recursive quicksort function
		quicksort(0, list.length - 1);
		
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
