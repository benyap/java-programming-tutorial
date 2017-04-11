package sorting.selection;

public class SelectionSort {
	
	
	public static int[] selectionSort(int[] list) {
		
		for(int i = 0; i < list.length; i++) {
			int minIndex = i;
			
			// Find the min
			for(int j = i; j < list.length; j++) {
				if (list[j] < list[minIndex]) {
					minIndex = j;
				}
			}
			
			// Swap the minimum element
			if (i != minIndex) {
				int temp = list[i];
				list[i] = list[minIndex];
				list[minIndex] = temp;			
			}
		}
		
		return list;
	}
	
	
	public static void main(String[] args) {
		int[] list = new int[]{10, 8, 1, 3, 7, 9, 9, 5};
		
		int[] sorted = selectionSort(list);
		
		for(int i = 0; i < list.length; i++) {
			System.out.print(sorted[i] + " ");
		}
	}
	
}
