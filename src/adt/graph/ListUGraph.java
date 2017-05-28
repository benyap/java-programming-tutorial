package adt.graph;

/**
 * A undirected graph ADT that uses an adjacency list.
 * Extends the {@code ListGraph} class and enforces bidirectional edges by 
 * always adding an edge in the opposite direction when a new edge is added.
 * Allows multiple edges.
 * @author bwyap
 *
 */
public class ListUGraph extends ListGraph implements UndirectedGraphInterface {
	
	/**
	 * Time complexity: O(1)
	 */
	@Override
	public boolean addEdge(String vertexA, String vertexB) {
		if (super.addEdge(vertexA, vertexB)) {
			// Add an edge in the other direction too
			return super.addEdge(vertexB, vertexA);
		}
		else return false;
	}
	
	/**
	 * Time complexity: O(|V|)
	 */
	@Override
	public boolean removeEdge(String vertexA, String vertexB) {
		if (super.removeEdge(vertexA, vertexB)) {
			// Remove edge from both sides
			return super.removeEdge(vertexB, vertexA);
		}
		return false;
	}
	
}
