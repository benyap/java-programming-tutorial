package sorting;

public class SelectionSort extends IntegerArraySorter{ 

	@Override
	public int[] sort(int[] list) {
		
		int i = 0;
		
		while (i < list.length) {
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
			
			i++;
		}

		return list;
	}

}
