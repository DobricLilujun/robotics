package test;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Algorithm 
{
	abstract void Astar_Euclidean(Graph graph);
	abstract ArrayList<LinkedList<Node_cube>> Astar_Manhattan(Graph graph);
	abstract public  ArrayList<LinkedList<Node_cube>> Astar_Chebyshev(Graph graph);
//	abstract static double findRealGx(Node_cube Node_cube);
}
