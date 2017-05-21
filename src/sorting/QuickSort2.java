package sorting;

/**
 * Adapted from <a href="https://www.youtube.com/watch?v=SLauY6PpjW4&t=426s">HackerRank</a>
 * @author bwyap
 *
 */
public class QuickSort2 extends IntegerArraySorter {
	
	private int[] array;
	
	@Override
	public int[] sort(int[] list) {
		
		this.array = list;
		
		// Call the recursive quicksort function
		quicksort(0, list.length - 1);
		
		return this.array;
	}
	
	/**
	 * Sort the array between the left and right indices
	 * @param left
	 * @param right
	 */
	private void quicksort(int left, int right) {
		if (left >= right) return;
		int index = partition(left, right, array[left]);
		
		quicksort(left, index - 1);
		quicksort(index, right);
	}
	
	/**
	 * Split the list into two partitions, the left section with values less than the pivot value,
	 * and the right section with values greater than the pivot value. 
	 * @param left
	 * @param right
	 * @param pivotValue
	 * @return the index of the partition
	 */
	private int partition(int left, int right, int pivotValue) {
		while(left <= right) {
			while(array[left] < pivotValue) {
				left++;
			}
			while(array[right] > pivotValue) {
				right--;
			}
			
			if (left <= right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
		
		return left;
	}

}
