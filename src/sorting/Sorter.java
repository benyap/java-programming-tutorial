package sorting;

/**
 * An object that provides a sort method
 * @author bwyap
 *
 * @param <T> this must be an object that contains sortable elements
 */
public abstract class Sorter<T> {

	/**
	 * Sort the list 
	 * @param list
	 * @return
	 */
	public abstract T sort(T list);
	
	/**
	 * Verify that the list is sorted
	 * @param list
	 * @return
	 */
	public abstract boolean verify(T list);
		
}
