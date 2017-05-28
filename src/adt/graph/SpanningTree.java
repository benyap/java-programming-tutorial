package adt.graph;

import java.util.List;

import adt.graph.algorithms.GraphChecker;

/**
 * A class that provides a basic implementation of Prim's Algorithm
 * which finds a spanning tree of a graph.
 * @author bwyap
 *
 */
public class SpanningTree {
	
	/**
	 * Generate an undirected spanning tree from a given graph.
	 * @param g the graph to generate the spanning tree from
	 * @param t the graph to insert the tree into
	 * @return
	 */
	public static UndirectedGraphInterface generateUndirectedSpanningTree(UndirectedGraphInterface g, UndirectedGraphInterface tree) {
		// First check that it is a connected graph
		if (GraphChecker.isWeaklyConnected(g)) {

			// Make sure the tree is empty
			tree.clear();
			
			// Get a list of the vertices. 
			//All of these have to eventually go into the tree.
			List<String> vertices = g.getVertices();
			
			// Choose a vertex in the graph
			String current = vertices.remove(0);
			// Put the vertex in the tree.
			tree.addVertex(current);
			
			// While there is a vertex not in the tree
			while(vertices.size() > 0) {
				
				// Look through vertices currently in the tree to find a new edge
				for(String treeVertex : tree.getVertices()) {
					List<String> graphNeighbours = g.getNeighbours(treeVertex);
					
					// Look through all neighbours of the chosen vertex
					for(String n : graphNeighbours) {
						
						// Find a neighbour not in the tree and that can connect to the tree
						if (!tree.hasVertex(n) && g.adjacent(treeVertex, n)) {
							// Put the vertex in the tree
							tree.addVertex(n);
							// Add the edge to the tree
							tree.addEdge(n, treeVertex);
							// Remove the vertex from the list so we know it is in the tree now
							vertices.remove(n);
						}
					}
				}
			}
		}
		
		return tree;
	}
	
}
