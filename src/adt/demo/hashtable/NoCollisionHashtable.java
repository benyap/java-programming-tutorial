package adt.demo.hashtable;

public class NoCollisionHashtable<K, V> extends GenericHashtable<K, V>{

	@Override
	public void remove(K key) {
		int pos = hash(key, table.length);
		if (keys[pos] == null) {
			throw new RuntimeException("No value exists for key '" + key + "'");
		}
		keys[pos] = null;		
	}

	@Override
	protected void collision(K key, int pos, V value) {
		throw new RuntimeException("Collision occurred for keys '" + key + "' and '" + keys[pos] + "'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(K key) {
		int pos = hash(key, table.length);
		if (keys[pos] == null) {
			throw new RuntimeException("No value exists for key '" + key + "'");
		}
		return (V) table[pos];
	}

}