package test;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Algorithm 
{
	abstract void Astar_Euclidean(Graph graph);
	abstract ArrayList<LinkedList<Node>> Astar_Manhattan(Graph graph);
	abstract ArrayList<LinkedList<Node>> Astar_Chebyshev(Graph graph);
//	abstract static double findRealGx(Node node);
}
