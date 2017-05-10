package sorting;

public class InsertionSort extends IntegerArraySorter {

	@Override
	public int[] sort(int[] list) {
		for(int i = 1; i < list.length; i++) {
			int index = i;
			while(index > 0 && list[index] < list[index - 1]) {
				int temp = list[index];
				list[index] = list[index - 1];
				list[index - 1] = temp;
				index--;
			}
		}
		
		return list;
	}
	
}
