package adt.demo;

public interface ListInterface<E> {
	/*
	 *  Operations:
	 *  	- add item
	 *  	- insert item
	 *  	- remove item
	 *  	- check if list contains item
	 *  	- clear
	 *  	- check size
	 */
	
	/**
	 * Add an item to the end of the list
	 * @param item
	 * @return true if the item was added successfully
	 */
	public boolean add(E item);
	
	
	/**
	 * 
	 * @param item
	 * @param position
	 * @return
	 */
	public boolean insert(E item, int position);
	
	
	/**
	 * Remove all instances of an item from the list
	 * @param item
	 * @return true if an item was removed from the list
	 */
	public boolean removeAll(E item);
	
	
	/**
	 * Remove the first instance of an item from the list
	 * @param item
	 * @return true if an item was removed from the list
	 */
	public boolean remove(E item);

	
	/**
	 * Check if the list contains an item
	 * @param item
	 * @return true if the list contains the item
	 */
	public boolean contains(E item);
	
	
	/**
	 * Clear the list
	 */
	public void clear();
	
	
	/**
	 * Check the size of the list
	 * @return
	 */
	public int size();
}
