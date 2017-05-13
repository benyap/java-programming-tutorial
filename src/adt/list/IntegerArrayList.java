package adt.list;

public class IntegerArrayList {

	
	/*
	 *  Operations:
	 *  	- add item
	 *  	- insert item
	 *  	- remove item
	 *  	- get an item
	 *  	- check if list contains item
	 *  	- clear
	 *  	- check size
	 */
	
	
	private int size;
	private int[] items;
	
	private final int INITIAL_SIZE = 5;
	
	
	public IntegerArrayList() {
		size = 0;
		clear();
	}


	public boolean add(int item) {
		if (size + 1 > items.length) {
			increaseCapacity();
		}
		
		// add item to list
		items[size] = item;
		size++;
		
		return true;
	}


	public boolean insert(int item, int position) throws IndexOutOfBoundsException {
		if (position > size || position < 0) {
			throw new IndexOutOfBoundsException("Index " + position + " out of range (" + size + ")");
		}
		else {
			// Everything after position must be moved one position down
			if (size + 1 > items.length) {
				increaseCapacity();
			}
			
			// Copy items backwards
			for(int i = size; i > position - 1; i--) {
				items[i + 1] = items[i];
			}
			
			// Insert new item
			items[position] = item;
			size++;
			
			return true;
		}
	}
	
	
	public int get(int index) throws IndexOutOfBoundsException {
		if (index >= size) {
			throw new IndexOutOfBoundsException("Index " + index + " out of range (" + size + ")");
		}
		else {
			return items[index];
		}
	}
	
	
	private void increaseCapacity() {
		int[] newItems = new int[items.length * 2];
		
		// copy items
		for(int i = 0; i < items.length; i++) {
			newItems[i] = items[i];
		}
		
		items = newItems;
	}
	
	
	public boolean remove(int item) {
		boolean removed = false;
		
		// search for the item
		for(int i = 0; i < size; i++) {
			if (items[i] == item) {
				// found the item
				// copy items to override it
				for(int j = i; j < size - 1; j++) {
					items[j] = items[j + 1];
				}
				size--;
				i--;
			}
		}
		
		return removed;
	}


	public boolean contains(int item) {
		for(int i : items) {
			if (i == item) return true;
		}
		return false;
	}

	
	public void clear() {
		items = new int[INITIAL_SIZE];
	}


	public int size() {
		return size;
	}
	
	
	public String toString() {
		String s = "[";
		
		for(int i = 0; i < size; i++) {
			s += items[i];
			if (i < size - 1) {
				s += ", ";
			}
		}
				
		return s + "]";
	}
	
}