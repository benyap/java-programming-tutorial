package adt.graph;

import java.util.List;

/**
 * Abstract Graph class that contains graph methods 
 * not specific to its storage implementation 
 * @author bwyap
 *
 */
public abstract class Graph implements GraphInterface {
	
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
	
}
