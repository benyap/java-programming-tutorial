package adt.demo;

/**
 * A custom hashtable implementation that maps String -> Integer
 * @author bwyap
 *
 */
public class Hashtable_StringString {
	
	public static final int DEFAULT_SIZE = 100;
	
	private String[] table;
	private String[] keys;
	
	
	public Hashtable_StringString() {
		table = new String[DEFAULT_SIZE];
		keys = new String[DEFAULT_SIZE];
	}
	
	
	/**
	 * Put a key-value pair into the hashtable.
	 * If a key-value pair is already in that location, 
	 * it is overridden if the key matches.
	 * @param key
	 * @param value
	 */
	public void put(String key, String value) {
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
	public String get(String key) {
		int pos = hash(key, table.length);
		if (keys[pos] == null) {
			throw new RuntimeException("No value exists for key '" + key + "'");
		}
		return table[pos];
	}
	
	
	/**
	 * Remove a value of a key if it exists
	 * @param key
	 */
	public void remove(String key) {
		int pos = hash(key, table.length);
		if (keys[pos] == null) {
			throw new RuntimeException("No value exists for key '" + key + "'");
		}
		keys[pos] = null;
	}

	
	/**
	 * Hash function to transform a String into an integer value
	 * @param s the string
	 * @param size the size to modulus the result by
	 * @return
	 */
	private int hash(String s, int size) {		
		int hash = 7;
		int prime = 31;
		for (int i = 0; i < s.length(); i++) {
			// 
		    hash = hash * prime + s.charAt(i);
		}
		return hash % size;
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
