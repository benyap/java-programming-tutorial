package sorting;

public abstract class IntegerArraySorter extends Sorter<int[]>{

	@Override
	public boolean verify(int[] list) {
		
		for(int i = 0; i < list.length - 1; i++) {
			if (list[i] > list[i + 1]) return false;
		}
		
		return true;
	}

}
