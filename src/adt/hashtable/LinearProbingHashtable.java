package adt.hashtable;

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
		
		// Linear probe each position until you have searched the entire table or hit a null
		while(keys[pos] != null && keys[pos] != key && count < table.length) {
			pos = (pos + 1) % table.length;
			count++;
		}
		
		if (keys[pos] == key) {
			return (V) table[pos];
		}
		else {
			throw new RuntimeException("No value exists for key '" + key + "'");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(K key) {
		int pos = hash(key, table.length);
		int count = 0;
		
		// Linear probe each position until you have searched the entire table or hit a null
		while(keys[pos] != null && keys[pos] != key && count < table.length) {
			pos = (pos + 1) % table.length;
			count++;
		}
		
		if (keys[pos] == key) {
			// remove the key
			keys[pos] = null;
			size--;
			
			// reposition items after removing
			count = 0;
			int prevpos = pos;
			int newpos = (pos + 1) % table.length;
			
			/*
			 * Conditions:
			 * 		- the next key is not null
			 * 		- the position of the next key is not the same as the removed item's
			 * 		- we have not iterated through the whole table
			 */
			while(
					keys[newpos] != null && 
					newpos != hash(key) &&
					count < table.length) {
				
				// shuffle item if it's not supposed to be there
				if (newpos != hash((K)keys[newpos])) {
					System.out.println("... repositioning " + keys[newpos] + " from " + newpos + " to " + prevpos);
					keys[prevpos] = keys[newpos];
					keys[newpos] = null;
					table[prevpos] = table[newpos];
					
					// calculate new positions for next check
					prevpos = newpos;
				}
				newpos = (newpos + 1) % table.length;
			}
		}
		else {
			throw new RuntimeException("No value exists for key '" + key + "'");
		}		
	}

	@Override
	protected void putCollision(K key, int pos, V value) {
		// Linear probe each position until you have searched the entire table or hit a null
		int count = 0;
		while(keys[pos] != null && count < table.length) {
			pos = (pos + 1) % table.length;
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
