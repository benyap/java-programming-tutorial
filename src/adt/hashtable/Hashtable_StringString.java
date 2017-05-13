package adt.hashtable;

/**
 * A custom hashtable implementation that maps String -> Integer
 * @author bwyap
 *
 */
public class Hashtable_StringString implements HashtableInterface<String, String>{
	
	public static final int DEFAULT_SIZE = 100;
	
	private String[] table;
	private String[] keys;
	private int size;
	
	public Hashtable_StringString() {
		table = new String[DEFAULT_SIZE];
		keys = new String[DEFAULT_SIZE];
	}
	
	@Override
	public void put(String key, String value) {
		int pos = hash(key, table.length);
		// fill empty slot or slot with the same key
		if (keys[pos] == key || keys[pos] == null) {
			table[pos] = value;
			keys[pos] = key;
			size++;
		}
		else {
			throw new RuntimeException("Collision occurred for keys '" + key + "' and '" + keys[pos] + "'");
		}
	}
	
	@Override
	public String get(String key) {
		int pos = hash(key, table.length);
		if (keys[pos] == null) {
			throw new RuntimeException("No value exists for key '" + key + "'");
		}
		return table[pos];
	}
	
	@Override
	public void remove(String key) {
		int pos = hash(key, table.length);
		if (keys[pos] == null) {
			throw new RuntimeException("No value exists for key '" + key + "'");
		}
		keys[pos] = null;
		size--;
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
	public int hash(String key) {
		return hash(key, table.length);
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public int capacity() {
		return table.length;
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
