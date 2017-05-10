package sorting;

public class BubbleSort extends IntegerArraySorter {
	
	@Override
	public int[] sort(int[] list) {
	
		for(int i = 0; i < list.length; i++) {
			boolean swapped = false;
			for(int j = 0; j < list.length - 1 ; j++) {
				if (list[j] > list[j + 1]) {
					// swap values
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					swapped = true;
				}
			}
			
			if (!swapped) return list;
		}
		return list;
	}
	
}
