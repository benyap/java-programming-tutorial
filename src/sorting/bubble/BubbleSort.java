package sorting.bubble;

public class BubbleSort {
	
	public static int[] bubbleSort(int[] list) {
		
		for(int i = 0; i < list.length; i++) {
			boolean swapped = false;
			
			for(int j = 0; j < list.length - 1; j++) {
				// Compare adjacent elements
				if (list[j] > list[j + 1]) {
					// Swap 
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					
					swapped = true;
				}
			}
			
			if (!swapped) {
				break;
			}
		}
		
		return list;
	}


	public static void main(String[] args) {
		int[] list = new int[]{10, 8, 1, 3, 7, 9, 9, 5};
		
		int[] sorted = bubbleSort(list);
		
		for(int i = 0; i < list.length; i++) {
			System.out.print(sorted[i] + " ");
		}
		
	}
		
}
