package adt.demo.hashtable;

public class LinearProbingHashtable<K, V> extends GenericHashtable<K, V> {

	public LinearProbingHashtable(int size) {
		super(size);
	}

	public LinearProbingHashtable() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public V get(K key) {
		int pos = hash(key, table.length);
		int count = 0;
		
		// Linear probe each position until you have searched the entire table
		while(keys[pos] != key && count < table.length) {
			pos = (++pos) % table.length;
			count++;
		}
		
		if (keys[pos] == key) {
			return (V) table[pos];
		}
		else {
			throw new RuntimeException("No value exists for key '" + key + "'");
		}
	}

	@Override
	public void remove(K key) {
		int pos = hash(key, table.length);
		int count = 0;
		
		// Linear probe each position until you have searched the entire table
		while(keys[pos] != key && count < table.length) {
			pos = (++pos) % table.length;
			count++;
		}
		
		if (keys[pos] == key) {
			keys[pos] = null;
			size--;
		}
		else {
			throw new RuntimeException("No value exists for key '" + key + "'");
		}		
	}

	@Override
	protected void putCollision(K key, int pos, V value) {
		// Linear probe each position until you have searched the entire table
		int count = 0;
		while(keys[pos] != null && count < table.length) {
			pos = (++pos) % table.length;
			count++;
		}
		
		if (keys[pos] == null) {
			keys[pos] = key;
			table[pos] = value;
			size++;
		}
		else {
			throw new RuntimeException("Failed to insert '" + key + "': hashtable full");
			// TODO add method to increase the size of the hashtable
		}
	}

}
