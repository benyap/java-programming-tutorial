package adt.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A directed graph ADT that uses an adjacency list.
 * Allows multiple edges.
 * @author bwyap
 *
 */
public class ListGraph implements GraphInterface {

	/**
	 * A mapping of vertices to a list of adjacent vertices
	 */
	private Map<String, List<String>> v;
	
	/**
	 * Create an empty Graph
	 */
	public ListGraph() {
		v = new HashMap<String, List<String>>();
	}
	
	/**
	 * Time complexity: O(1)
	 */
	@Override
	public boolean addVertex(String name) {
		// Ensure vertex is unique
		if (!v.containsKey(name)) {
			// Add the vertex
			v.put(name, new ArrayList<String>());
			return true;
		}
		return false;
	}
	
	/**
	 * Time complexity: O(1)
	 */
	@Override
	public boolean addEdge(String vertexA, String vertexB) {
		// Ensure vertices exist
		if (hasVertex(vertexA) && hasVertex(vertexB)) {
			// Add vertexB to vertexA's adjacency list
			v.get(vertexA).add(vertexB);
			return true;
		}
		return false;
	}
	
	/**
	 * Time complexity: O(|E|)
	 */
	@Override
	public boolean removeVertex(String name) {
		if (!hasVertex(name)) return false;
		for(String vertex : v.keySet()) {
			// Remove the edge from all vertices that may have a connection
			while(v.get(vertex).contains(name)) {
				v.get(vertex).remove(name);				
			}
		}
		// remove the vertex
		v.remove(name);
		return true;
	}
	
	/**
	 * Time complexity: O(|V|)
	 */
	@Override
	public boolean removeEdge(String vertexA, String vertexB) {
		// Ensure vertices exist
		if (hasVertex(vertexA) && hasVertex(vertexB)) {
			// Remove vertexB from vertexA's adjacency list
			return v.get(vertexA).remove(vertexB);	
		}
		return false;
	}

	/**
	 * Time complexity: O(|V|)
	 */
	@Override
	public boolean adjacent(String vertexA, String vertexB) {
		// Ensure vertices exist
		if (hasVertex(vertexA) && hasVertex(vertexB)) {
			// Check if vertexB is in vertexA's adjacency list
			return v.get(vertexA).contains(vertexB);
		}
		return false;
	}
	
	@Override
	public boolean hasVertex(String vertex) {
		return v.containsKey(vertex);
	}
	
	@Override
	public List<String> getVertices() {
		// Get list of all vertices
		List<String> vertices = new ArrayList<String>();
		for(String s : v.keySet()) {
			vertices.add(s);
		}
		return vertices;
	}
	
	@Override
	public List<String> getNeighbours(String vertex) {
		// Ensure vertex exists
		if (!hasVertex(vertex)) return null;
		// Get neighbours of vertex
		return new ArrayList<String>(v.get(vertex));
	}
	
	@Override
	public String toString() {
		String s = "\n";
		
		// Print each vertex
		for(String vertex : v.keySet()) {
			s += vertex + ": {";
			
			// Print each vertex's adjacencies
			boolean haveAdjacencies = false;
			List<String> adjacencies = v.get(vertex);
			for(String a : adjacencies) {
				s += a + ", ";
				haveAdjacencies = true;
			}
			
			if (haveAdjacencies) s = s.substring(0, s.length() - 2);
			s += "}\n";
		}
		
		return s;
	}
	
}
