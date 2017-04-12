package adt.demo;

public class GenericHashtable<K,V> {
	

	public static final int DEFAULT_SIZE = 100;
	
	private Object[] table;
	private Object[] keys;
	
	
	public GenericHashtable() {
		table = new Object[DEFAULT_SIZE];
		keys = new Object[DEFAULT_SIZE];
	}
	
	
	/**
	 * Put a key-value pair into the hashtable.
	 * If a key-value pair is already in that location, 
	 * it is overridden if the key matches.
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		int pos = hash(key, table.length);
		// fill empty slot or slot with the same key
		if (keys[pos] == key || keys[pos] == null) {
			table[pos] = value;
			keys[pos] = key;
		}
		else {
			throw new RuntimeException("Collision occurred for keys '" + key + "' and '" + keys[pos] + "'");
		}
	}
	
	
	/**
	 * Retrieve the value of a key if it exists
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public V get(K key) {
		int pos = hash(key, table.length);
		if (keys[pos] == null) {
			throw new RuntimeException("No value exists for key '" + key + "'");
		}
		return (V) table[pos];
	}
	
	
	/**
	 * Remove a value of a key if it exists
	 * @param key
	 */
	public void remove(K key) {
		int pos = hash(key, table.length);
		if (keys[pos] == null) {
			throw new RuntimeException("No value exists for key '" + key + "'");
		}
		keys[pos] = null;
	}

	
	/**
	 * Hash function to transform an object into an integer value
	 * @param s the string
	 * @param size the size to modulus the result by
	 * @return
	 */
	private int hash(K s, int size) {
		// used default Object hashcode method
		return s.hashCode() % size;
	}
	
	
	@Override
	public String toString() {
		String s = "{";
		for (int i = 0; i < table.length; i++) {
			if (keys[i] != null) {
				s += keys[i] + ":";
				s += table[i] + ", ";
			}
		}
		return s.substring(0, s.length() - 2) + "}";
	}
	
}
