package adt.graph.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import adt.graph.GraphInterface;

/**
 * This class provides utility functions for verifying properties of a graph
 * @author bwyap
 *
 */
public class GraphChecker {
	
	static final boolean DEBUG = false;
	
	/**
	 * Checks if a graph is weakly connected.
	 * A weakly connected graph has an undirected path from any vertex to any other vertex in the graph.
	 * @param g
	 * @return
	 */
	public static boolean isWeaklyConnected(GraphInterface g) {
		// Get vertices
		List<String> vertices = g.getVertices();
		if (vertices.size() == 0) return true;
		
		// Create a stack to contain vertices
		List<String> stack = new LinkedList<String>();
		
		// List of completed vertices
		List<String> complete = new LinkedList<String>();
		
		// Put first vertex into the stack
		stack.add(vertices.get(0));
		
		// Perform DFS
		while(stack.size() > 0) {
			// Get the current vertex and its predecessor
			if (DEBUG) System.out.println("Stack > " + stack);
			String current = stack.remove(stack.size() - 1);
			
			// Get the neighbours of the current vertex
			List<String> neighbours = g.getNeighbours(current);
			if (DEBUG) System.out.print("Checking " + current + "\nNeighbours: ");
			
			// Check through all neighbours of the current vertex
			while(neighbours.size() > 0) {
				// Get a neighbour
				String neighbour = neighbours.remove(neighbours.size() - 1);
				if (!complete.contains(neighbour) && !stack.contains(neighbour)) {
					if (DEBUG) System.out.print(neighbour + " ");
					stack.add(neighbour);
				}
			}
			complete.add(current);
			if (DEBUG) System.out.println("\n" + current + " complete > " + complete + "\n");
		}
		
		// If all vertices have been visited, then the graph is connected.
		System.out.println("Completed: " + complete.size() + ", vertices: " + vertices.size() + "\n");
		return complete.size() == vertices.size();
	}
	
	/**
	 * Check if a graph contains a cycle.
	 * @param g
	 * @return
	 */
	public static boolean hasCycle(GraphInterface g) {		
		// Get vertices
		List<String> vertices = g.getVertices();
		if (vertices.size() == 0) return true;
		
		// Create a stack to contain vertices
		List<String> stack = new LinkedList<String>();
		List<String> predecessors = new LinkedList<String>();
		
		// List of completed vertices
		List<String> complete = new LinkedList<String>();
		
		// Put first vertex into the stack
		stack.add(vertices.get(0));
		predecessors.add(vertices.get(0));
		
		// Perform DFS
		while(stack.size() > 0) {
			// Get the current vertex and its predecessor
			String current = stack.remove(stack.size() - 1);
			String predecessor = predecessors.remove(predecessors.size() - 1);
			
			// Get the neighbours of the current vertex
			List<String> neighbours = g.getNeighbours(current);
			
			// Check through all neighbours of the current vertex
			while(neighbours.size() > 0) {
				// Get a neighbour
				String neighbour = neighbours.remove(neighbours.size() - 1);
				if (complete.contains(neighbour) || stack.contains(neighbour)) {
					if (neighbour != predecessor) 
						// Neighbour that is not predecessor found 
						// Graph contains cycle
						return true;
				}
				else {
					// Add the neighbour to the stack to check
					stack.add(neighbour);
					predecessors.add(current);
				}
			}
			complete.add(current);
		}
		// No cycle detected
		return false;
	}
	
	/**
	 * Checks if two graphs contain the same vertices.
	 * All vertices in the graphs must be unique.
	 * Time complexity: O(|V1|+|V2|)
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean containsAllVertices(GraphInterface a, GraphInterface b) {
	    final Set<String> s1 = new HashSet<String>(a.getVertices());
	    final Set<String> s2 = new HashSet<String>(b.getVertices());
	    return s1.equals(s2);
	}
	
	/**
	 * Check if a graph is simple.
	 * A simple graph contains no loops and no multiple edges.
	 * Time complexity: O(|V|^2)
	 * @param g
	 * @return
	 */
	public static boolean isSimple(GraphInterface g) {
		// Check for loops
		List<String> vertices = g.getVertices();
		for(String v : vertices) {
			if (g.adjacent(v, v)) return false;
		}
		
		// Check for multiple edges
		for(String a : vertices) {
			for(String b : vertices) {
				if (g.edgeCount(a, b) > 1) return false;
			}
		}
		
		// Graph is simple
		return true;
	}
	
	/**
	 * Check if a graph is a tree. 
	 * A tree is a simple, connected graph with no circuits.
	 * @param g
	 * @return
	 */
	public static boolean isTree(GraphInterface g) {
		if (!isSimple(g)) return false;
		if (!isWeaklyConnected(g)) return false;
		if (hasCycle(g)) return false;
		return true;
	}
	
	/**
	 * Checks if a given graph is a valid spanning tree of another graph.
	 * Time complexity: O(|V|^2) to check if all edges in the tree are in the graph
	 * @return
	 */
	public static boolean isSpanningTree(GraphInterface g, GraphInterface tree) {
		// Spanning tree must be a tree and must contain all vertices of the graph
		if (!isTree(tree)) return false;
		if (!containsAllVertices(tree, g)) return false;
		
		// Check if all edges in the tree are in the graph g
		List<String> vertices = tree.getVertices();
		for(String a : vertices) {
			for(String b : vertices) {
				if (tree.adjacent(a, b) && !g.adjacent(a, b)) return false;
			}
		}
		
		return true;
	}
	
}
