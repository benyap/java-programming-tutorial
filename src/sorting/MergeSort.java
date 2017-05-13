package sorting;

public class MergeSort extends IntegerArraySorter {
	
	private int[] aux;
	private int[] array;
	
	@Override
	public int[] sort(int[] list) {
		this.array = list;
		this.aux = new int[list.length];

		mergesort(0, list.length - 1);
		
		return list;
	}
	
	/**
	 * Sort the numbers in the array between the given indexes recursively.
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
	 * Merge the two partitions indicated by the given indexes.
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	private void merge(int lo, int mid, int hi) {
		// Copy the array into aux
		for (int i = lo; i <= hi; i++) {
			aux[i] = array[i];
		}
		
		int left = lo;
		int right = mid + 1;
		int index = lo;
		
		// Move the lower of other element of the 
		//two partitions into the array
		while(left <= mid && right <= hi) {
			if (aux[left] <= aux[right]) {
				array[index++] = aux[left++];
			}
			else {
				array[index++] = aux[right++];
			}
		}
		
		// Move any leftover elements into the array
		while (left <= mid) {
			array[index++] = aux[left++];
		}
		
		while (right <= hi) {
			array[index++] = aux[right++];
		}
	}
	
}
