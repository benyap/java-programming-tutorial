package adt.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A directed graph ADT that uses an adjacency matrix.
 * Allows multiple edges.
 * @author bwyap
 *
 */
public class MatrixGraph implements GraphInterface {
	
	/**
	 * The adjacency matrix
	 */
	private int[][] array;
	
	/**
	 * A mapping of vertices to indices in the matrix
	 */
	private Map<String, Integer> vertices;
	
	/**
	 * A mapping of vertices to indices in the matrix,
	 * used to maintain ordering for the toString() method
	 */
	private List<String> indices;
	
	/**
	 * Create an empty Graph
	 */
	public MatrixGraph() {
		vertices = new HashMap<String, Integer>();
		indices = new ArrayList<String>();
	}

	/**
	 * Time complexity: O(|V|^2)
	 */
	@Override
	public boolean addVertex(String name) {
		// Ensure unique vertex name
		if (vertices.containsKey(name)) return false;
		
		// Add vertex and increase matrix size
		indices.add(name);
		vertices.put(name, vertices.keySet().size());
		int[][] a = new int[vertices.size()][vertices.size()];
		
		// Copy old matrix into new matrix with extra spot for the new vertex
		if (array != null) {
			for(int i = 0; i < array.length; i++) {
				for(int j = 0; j < array.length; j++) {
					a[i][j] = array[i][j];
				}
			}			
		}
		
		array = a;
		
		return true;
	}

	/**
	 * Time complexity: O(1)
	 */
	@Override
	public boolean addEdge(String vertexA, String vertexB) {
		// Ensure vertices exist
		if (!vertices.containsKey(vertexA) || !vertices.containsKey(vertexB)) return false;
		
		// Add the edge
		array[vertices.get(vertexA)][vertices.get(vertexB)] = array[vertices.get(vertexA)][vertices.get(vertexB)] + 1;
		
		return true;
	}
	
	/**
	 * Time complexity: O(|V|^2)
	 */
	@Override
	public boolean removeVertex(String name) {
		// Check that vertex exists
		if (!vertices.containsKey(name)) return false;
		
		// Remove the vertex and reduce matrix size
		int index = vertices.get(name);
		vertices.remove(name);
		indices.remove(name);
		int[][] a = new int[vertices.size()][vertices.size()];
		
		// Copy the array, ignoring the row/column of the removed index
		if (array != null) {
			int array_i = 0, array_j = 0;
			for(int i = 0; i < a.length; i++) {
				if (array_i == index) array_i++;
				for(int j = 0; j < a.length; j++) {
					if (array_j == index) array_j++;
					a[i][j] = array[array_i][array_j];
					array_j++;
				}
				array_j = 0;
				array_i++;
			}
		}
		
		array = a;
		
		return true;
	}

	/**
	 * Time complexity: O(1)
	 */
	@Override
	public boolean removeEdge(String vertexA, String vertexB) {
		// Check that the vertices exist
		if (!vertices.containsKey(vertexA) || !vertices.containsKey(vertexB)) return false;
		
		// Reduce vertex edge count
		if (array[vertices.get(vertexA)][vertices.get(vertexB)] > 0) {
			array[vertices.get(vertexA)][vertices.get(vertexB)] = array[vertices.get(vertexA)][vertices.get(vertexB)] - 1;
			return true;			
		}
		else return false;
	}

	/**
	 * Time complexity: O(1)
	 */
	@Override
	public boolean adjacent(String vertexA, String vertexB) {
		// Check that vertex exists
		if (!vertices.containsKey(vertexA) || !vertices.containsKey(vertexB)) return false;
		
		// Check if edge exists
		return array[vertices.get(vertexA)][vertices.get(vertexB)] > 0;
	}
	
	@Override
	public boolean hasVertex(String vertex) {
		return vertices.containsKey(vertex);
	}
	
	@Override
	public List<String> getVertices() {
		// Get list of all vertices
		List<String> vertices = new ArrayList<String>();
		for(String s : this.vertices.keySet()) {
			vertices.add(s);
		}
		return vertices;
	}
	
	@Override
	public List<String> getNeighbours(String vertex) {
		// Check that vertex exists
		if (!hasVertex(vertex)) return null;
		
		// Get all vertices in matrix that are adjacent to vertex
		List<String> neighbours = new ArrayList<String>();
		int vertex_i = vertices.get(vertex);
		for(int i = 0; i < array[vertex_i].length; i++) {
			if (array[vertex_i][i] > 0) neighbours.add(indices.get(i));
		}
		return neighbours;
	}
	
	@Override
	public int edgeCount(String vertexA, String vertexB) {
		if (!adjacent(vertexA, vertexB)) return 0;
		List<String> neighbours = getNeighbours(vertexA);
		int count = 0;
		for(String n : neighbours) {
			if (n == vertexB) count++;
		}
		return count;
	}
	
	@Override
	public String toString() {
		if (array == null) return "\n";
		
		// Print top row (vertex names)
		String s = "\n\t";		
		for(int i = 0; i < array.length; i++) {
			s += indices.get(i) + "\t";
		}
		
		// Print the table
		for(int i = 0; i < array.length; i++) {
			s += "\n" + indices.get(i) + "\t";	// Print vertex name at start of each row
			for(int j = 0; j < array.length; j++) {
				s += array[i][j] + "\t";
			}
		}
		
		return s + "\n";
	}
	
}
