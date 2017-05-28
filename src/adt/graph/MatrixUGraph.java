package adt.graph;

/**
 * A undirected graph ADT that uses an adjacency matrix.
 * Extends the {@code MatrixGraph} class and enforces bidirectional edges by 
 * always adding an edge in the opposite direction when a new edge is added.
 * Allows multiple edges.
 * @author bwyap
 *
 */
public class MatrixUGraph extends MatrixGraph implements UndirectedGraphInterface {
	
	/**
	 * Time complexity: O(1)
	 */
	@Override
	public boolean addEdge(String vertexA, String vertexB) {
		if (super.addEdge(vertexA, vertexB)) {
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
