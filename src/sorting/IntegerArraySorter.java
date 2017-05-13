package sorting;

import java.util.HashMap;

public abstract class IntegerArraySorter extends Sorter<int[]>{

	@Override
	public boolean verify(int[] original, int[] sorted) {
		
		// Check that values are in order
		for(int i = 0; i < sorted.length - 1; i++) {
			if (sorted[i] > sorted[i + 1]) return false;
		}
		
		// Check that each number in the original list is also contained in the sorted list
		HashMap<Integer, Integer> originalCount = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> sortedCount = new HashMap<Integer, Integer>();
		
		for(int i : original) {
			if (originalCount.containsKey(i)) originalCount.put(i, originalCount.get(i) + 1);
			else originalCount.put(i, 1);
		}
		
		for(int i : sorted) {
			if (sortedCount.containsKey(i)) sortedCount.put(i, sortedCount.get(i) + 1);
			else sortedCount.put(i, 1);
		}
		
		for(int k : originalCount.keySet()) {
			if (originalCount.get(k) != sortedCount.get(k)) return false;
		}
		
		return true;
	}

}
