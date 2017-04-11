package sorting.insertion;

public class InsertionSort {

	public static int[] insertionSort(int[] list) {
		
		for(int i = 1; i < list.length; i++) {
			int index = i;
			
			// Swap the next element into the right position
			while(index > 0 && list[index] < list[index - 1]) {
				// Swap
				int temp = list[index];
				list[index] = list[index - 1];
				list[index - 1] = temp;
				
				index--;
			}
		}
		
		return list;
	}
	
	
	public static void main(String[] args) {
		int[] list = new int[]{10, 8, 1, 3, 7, 9, 9, 5};
		
		int[] sorted = insertionSort(list);
		
		for(int i = 0; i < list.length; i++) {
			System.out.print(sorted[i] + " ");
		}
	}
}
