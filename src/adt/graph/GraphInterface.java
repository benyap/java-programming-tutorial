package adt.graph;

import java.util.List;

/**
 * This interface provides methods that a graph should provide,
 * using Strings to uniquely identify vertices.
 * @author bwyap
 *
 */
public interface GraphInterface {
	
	/**
	 * Add a vertex to the graph.
	 * The vertex name must be unique within the graph.
	 * @param name
	 * @return true if the vertex is unique and was successfully added.
	 */
	public boolean addVertex(String name);
	
	/**
	 * Add an edge from vertexA to vertexB.
	 * Both vertices must exist in the graph.
	 * @param vertexA
	 * @param vertexB
	 * @return true if the edge was added successfully, false if one or both of the vertices do not exist.
	 */
	public boolean addEdge(String vertexA, String vertexB);
	
	/**
	 * Remove the specified vertex from the graph and all associated edges.
	 * The vertex must exist in the graph.
	 * @param name
	 * @return true if the vertex was successfully removed.
	 */
	public boolean removeVertex(String name);
	
	/**
	 * Remove an edge from vertexA to vertexB.
	 * Both vertices must exist in the graph.
	 * @param vertexA
	 * @param vertexB
	 * @return true if the edge was removed successfully.
	 */
	public boolean removeEdge(String vertexA, String vertexB);
	
	/**
	 * Check if vertexA is adjacent to vertexB.
	 * Both vertices must exist in the graph.
	 * @param VertexA
	 * @param vertexB
	 * @return true if the two vertices are adjacent, false otherwise.
	 */
	public boolean adjacent(String vertexA, String vertexB);
	
	
	// Other useful methods
	
	/**
	 * Check if the vertex exists.
	 * @param vertex
	 * @return true if the vertex exists, false otherwise.
	 */
	public boolean hasVertex(String vertex);
	
	/**
	 * Get a list of all vertices in the graph
	 * @return
	 */
	public List<String> getVertices();
	
	/**
	 * Get the neighbours of a specified vertex.
	 * Returns null if vertex doesn't exist. 
	 * @param vertex
	 * @return
	 */
	public List<String> getNeighbours(String vertex);
	
}
