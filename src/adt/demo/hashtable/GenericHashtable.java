package adt.demo.hashtable;

public abstract class GenericHashtable<K,V> implements HashtableInterface<K, V> {
	
	public static final int DEFAULT_SIZE = 100;
	
	protected Object[] table;
	protected Object[] keys;
	
	public GenericHashtable() {
		table = new Object[DEFAULT_SIZE];
		keys = new Object[DEFAULT_SIZE];
	}
	
	@Override
	public void put(K key, V value) {
		int pos = hash(key, table.length);
		// fill empty slot or slot with the same key
		if (keys[pos] == key || keys[pos] == null) {
			table[pos] = value;
			keys[pos] = key;
		}
		else {
			collision(key, pos, value);
		}
	}
	
	/**
	 * Collision handler for when two keys receive the same hash.
	 * To be implemented by a sub class.
	 * @param key the key
	 * @param pos the hashed position of the key
	 * @param value the value attached to the key
	 */
	protected abstract void collision(K key, int pos, V value);
	
	/**
	 * Hash function to transform an object into an integer value
	 * @param s the string
	 * @param size the size to modulus the result by
	 * @return
	 */
	protected int hash(K s, int size) {
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
