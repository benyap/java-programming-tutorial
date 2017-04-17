package adt.demo.hashtable;

public interface HashtableInterface<K, V> {

	/**
	 * Put a key-value pair into the hashtable.
	 * If a key-value pair is already in that location, 
	 * it is overridden if the key matches.
	 * @param key
	 * @param value
	 */
	public void put(K key, V value);
	
	/**
	 * Retrieve the value of a key if it exists
	 * @param key
	 * @return
	 */
	public V get(K key);
	
	/**
	 * Remove a value of a key if it exists
	 * @param key
	 */
	public void remove(K key);
	
	/**
	 * Get the number of objects in the hashtable
	 * @return
	 */
	public int size();
	
	/**
	 * Get the current capacity of the hashtable
	 * @return
	 */
	public int capacity();
	
	/**
	 * Hash function that turns the key into a integer hash
	 * @param key
	 * @return
	 */
	public int hash(K key);
}
