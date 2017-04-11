package adt.demo;

public class GenericArrayList<E> implements ListInterface<E> {
	
	
	private int size;
	private Object[] items;
	
	private final int INITIAL_SIZE = 10;
	
	
	public GenericArrayList() {
		clear();
	}
	
	
	@Override
	public boolean add(E item) {
		
		if (size + 1 > items.length) {
			increaseCapacity();
		}
		
		// add item to list
		items[size] = item;
		size++;
		
		return true;
	}
	

	@Override
	public boolean insert(E item, int position) {
		if (position > size || position < 0) {
			return false;
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

	
	@Override
	public boolean removeAll(E item) {
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
	
	
	@Override
	public boolean remove(E item) {
		// search for the item
		for(int i = 0; i < size; i++) {
			if (items[i] == item) {
				// found the item
				// copy items to override it
				for(int j = i; j < size - 1; j++) {
					items[j] = items[j + 1];
				}
				size--;
				return true;
			}
		}
		
		return false;
	}
	
	
	@Override
	public boolean contains(E item) {
		for(Object i : items) {
			if (i.equals(item)) return true;
		}
		
		return false;
	}
	
	
	@Override
	public void clear() {
		items = new Object[INITIAL_SIZE];
		size = 0;
	}

	
	@Override
	public int size() {
		return size;
	}
	

	@Override
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
	
	
	/**
	 * Increase the capacity of the array used to hold objects
	 */
	private void increaseCapacity() {
		Object[] newItems = new Object[items.length * 2];
		
		// copy items
		for(int i = 0; i < items.length; i++) {
			newItems[i] = items[i];
		}
		
		items = newItems;
	}
}
