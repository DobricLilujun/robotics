package test;

import java.util.ArrayList;
import java.util.LinkedList;

// Abstract class Algorithm
public abstract class Algorithm {

	// Abstract method Astar_Euclidean, implements A* algorithm using Euclidean
	// distance
	abstract void Astar_Euclidean(Graph graph);

	// Abstract method Astar_Manhattan, implements A* algorithm using Manhattan
	// distance
	abstract ArrayList<LinkedList<Node>> Astar_Manhattan(Graph graph);

	// Abstract method Astar_Chebyshev, implements A* algorithm using Chebyshev
	// distance
	abstract ArrayList<LinkedList<Node>> Astar_Chebyshev(Graph graph);
	// abstract static double findRealGx(Node node);
	// The following code is commented out, possibly for debugging or other reasons
	// abstract static double findRealGx(Node node);
}
