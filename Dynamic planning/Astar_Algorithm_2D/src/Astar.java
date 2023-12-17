
import java.util.ArrayList;
import java.util.LinkedList;

import test.Node_cube;

// This Java code implements a variant of the A* (A-star) search algorithm for finding paths in two dimensions.
// The algorithm is encapsulated in a class Astar, which inherits from an abstract class called Algorithm.
// The code was written 100% by me, that is, Lujun Li, because I am very accustomed to using JAVA to write code, so the dynamic path algorithm part of A*, 
// I used JAVA to write it.
public class Astar extends Algorithm {

	// These two methods are primarily used to handle distances between nodes and
	// equality judgments in subsequent code.
	// In other parts of the Astar class, these methods are used to calculate the
	// distance between nodes and to determine whether nodes are equal.

	public static double distance_NodeCube_Node(Node_cube a, Node b) {
		return Math.sqrt((Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2)));
	}

	public static boolean equals_NodeCube_NodeCube(Node_cube a, Node_cube b) {
		if ((a.x == b.x) && (a.y == b.y)) {
			return true;
		} else {
			return false;
		}
	}

	// Defines a static method named Cal_HX for calculating the value of the
	// heuristic function H(x) within a graph
	// For this function, the graph is built according to a cube maze

	public static double Cal_HX(LinkedList<Node_cube> guide, Node a, Graph graph)// 开始编计算HX的函数
	{
		int flag = 0;
		double HX = 0;
		double hx = 0;
		Node_cube best = guide.get(0);
		for (int i = 1; i < guide.size(); i++) {
			if (distance_NodeCube_Node(guide.get(i), a) < distance_NodeCube_Node(best, a)) {
				best = guide.get(i);
				flag = i;
			}
		}

		if (flag < 5) {
			HX = Math.sqrt(Math.pow(graph.en_des[0][1] - best.x, 2) + Math.pow(graph.en_des[1][1] - best.x, 2));
		} else {
			double p1 = Math.atan2(best.y - guide.get(flag - 5).y, best.x - guide.get(flag - 5).x);
			double p2 = a.angle;
			// System.out.println("p1 : "+p1);
			// System.out.println("p2 : "+p2);
			double p = Math.abs(p1 - p2);
			HX = Math.sqrt(Math.pow(graph.en_des[0][1] - best.x, 2) + Math.pow(graph.en_des[1][1] - best.x, 2));
			HX = HX * (1 + p);
		}

		// while(!equals_NodeCube_NodeCube(guide.get(i),best))
		// {
		// if(Math.abs(guide.get(i).x-guide.get(i+1).x)+Math.abs(guide.get(i).y-guide.get(i+1).y)==2)
		// {
		// hx = hx+Math.sqrt(2.0);
		// }
		// else
		// {
		// hx = hx+1.0;
		// }
		// i++;
		// }
		// System.out.println(hx);
		// System.out.println(distance_NodeCube_Node(best,a)+Math.sqrt(Math.pow(graph.en_des[0][1]-best.x,
		// 2)+Math.pow(graph.en_des[1][1]-best.x, 2)));
		return HX;
	}

	public static int[] Find_Closest(double x, double y) {
		int[] result = new int[2];
		double x_min = Math.floor(x);
		double x_max = Math.floor(x) + 1;
		double y_min = Math.floor(y);
		double y_max = Math.floor(y) + 1;
		if ((x < x_min + 0.5) && (y < y_min + 0.5)) {
			result[0] = (int) x_min;
			result[1] = (int) y_min;
		} else if ((x > x_min + 0.5) && (y > y_min + 0.5)) {
			result[0] = (int) x_max;
			result[1] = (int) y_max;
		} else if ((x < x_min + 0.5) && (y > y_min + 0.5)) {
			result[0] = (int) x_min;
			result[1] = (int) y_max;
		} else if ((x > x_min + 0.5) && (y < y_min + 0.5)) {
			result[0] = (int) x_max;
			result[1] = (int) y_min;
		} else {
			result[0] = (int) x_min;
			result[1] = (int) y_min;
		}
		return result;
	}

	// This code defines a static method, Conver_graph, whose function is to convert
	// the input Graph into a graphical object called test.Graph. The following is
	// the main logic of the method.

	// The purpose of this method is to generate a new test.Graph object that
	// contains information about the original graph, including the dimensions of
	// the map, the location of obstacles, and the location of the start and end
	// points.
	@SuppressWarnings("null")
	public static test.Graph Conver_graph(Graph graph) {
		LinkedList<Integer> obstacle_X = new LinkedList<>();
		LinkedList<Integer> obstacle_Y = new LinkedList<>();
		int en_des[][] = new int[2][2];
		int en[] = new int[2];
		int des[] = new int[2];
		en = Find_Closest(graph.en_des[0][0], graph.en_des[1][0]);
		des = Find_Closest(graph.en_des[0][1], graph.en_des[1][1]);
		en_des[0][0] = en[0];
		en_des[1][0] = en[1];
		en_des[0][1] = des[0];
		en_des[1][1] = des[1];
		int xlength = (int) graph.xlength;
		int ylength = (int) graph.ylength;
		Node members[][] = new Node[xlength][ylength];
		for (int i = 0; i < xlength; i++) {
			// System.out.println(xlength);
			// System.out.println(ylength);
			// System.out.println("i " +i);
			for (int j = 0; j < ylength; j++) {
				// System.out.println(j);
				// System.out.println("i am here");
				members[i][j] = new Node((double) i, (double) j);

				if (!isAdmissible(members[i][j], graph)) {
					// System.out.println("i am here");
					obstacle_X.add(i);
					obstacle_Y.add(j);
				}

			}
		}

		int obstacle[][] = new int[2][obstacle_X.size()];
		for (int i = 0; i < obstacle_X.size(); i++) {
			obstacle[0][i] = obstacle_X.get(i);
			obstacle[1][i] = obstacle_Y.get(i);
		}
		test.Graph gr = new test.Graph(xlength, ylength, obstacle, en_des);
		// System.out.println("xlength"+xlength);
		// System.out.println("ylength"+ylength);
		// System.out.println("ylength"+ylength);
		return gr;
	}

	// This code defines a concrete implementation of the A* algorithm for 2D maps
	// using the Chebyshev distance metric. This code implements an A* algorithm
	// that finds the shortest path from the start point to the end point on a
	// two-dimensional map using the Chebyshev distance metric and returns the path,
	// an open list, a closed list, and guidance information.
	ArrayList<LinkedList<Node>> Astar_2D_Cheb(Graph graph, int NumOfSearhPoints, double StepSize, double SearchAngle,
			double angle0) {
		test.Graph gr = Conver_graph(graph);
		test.Astar sObj = new test.Astar();
		ArrayList<LinkedList<Node_cube>> guide = sObj.Astar_Chebyshev(gr);
		LinkedList<Node> guide_Node = new LinkedList<>();
		// System.out.println("guide.get(0).size()--------------------------"+guide.get(0).size());
		for (int i = 0; i < guide.get(0).size(); i++) {
			Node temp = new Node((double) guide.get(0).get(i).x, (double) guide.get(0).get(i).y);
			guide_Node.add(temp);
		}
		// System.out.println("guide_Node.size()--------------------------"+guide_Node.size());
		LinkedList<Node> openlist = new LinkedList<>();
		LinkedList<Node> closelist = new LinkedList<>();
		LinkedList<Node> result = new LinkedList<>();
		Node temp[] = new Node[NumOfSearhPoints];
		int HalfNumOfSearhPoints = 0;

		if (NumOfSearhPoints % 2 == 0) {
			System.out.println("The search times is illegal!");
			System.exit(0);
		} else {
			HalfNumOfSearhPoints = (NumOfSearhPoints - 1) / 2;
		}
		Node en = new Node(graph.en_des[0][0], graph.en_des[1][0]);
		Node des = new Node(graph.en_des[0][1], graph.en_des[1][1]);
		en.Father = null;
		en.Gx = 0;
		en.Hx = Cal_HX(guide.get(0), en, graph);
		en.Fx = en.Gx + en.Hx;
		en.angle = angle0;
		openlist.add(en);
		en.isopen = true;

		// int flag = 0;
		Node best = null;

		while (openlist.size() != 0) {
			openlist = bubbleSort(openlist);
			best = openlist.getLast();
			// System.out.println("x = "+ best.x + "y = "+ best.y);
			if (equals(best, des)) {
				break;
			} else {
				openlist.remove(best);
				for (int i = -HalfNumOfSearhPoints; i <= HalfNumOfSearhPoints; i++) {
					temp[i + HalfNumOfSearhPoints] = new Node(
							best.x + StepSize * Math.cos(best.angle + i * SearchAngle),
							best.y + StepSize * Math.sin(best.angle + i * SearchAngle));
					Node a = temp[i + HalfNumOfSearhPoints];
					Segment trace = new Segment(best.x, best.y, a.x, a.y);
					if (isAdmissible(a, graph) && isCrossAdmissible(trace, graph)) {
						a.Father = best;
						a.Gx = best.Gx + StepSize;
						a.angle = best.angle + i * SearchAngle;
						a.Hx = Cal_HX(guide.get(0), a, graph);
						a.Fx = a.Gx + a.Hx;
						// a.depth = findRealDepth(a);

						// System.out.println("a.angle"+a.angle);
						if (!isOpen(a, openlist))
							openlist.add(a);
					}
				}
			}
			closelist.add(best);
		}

		result = findRealTrace(best);
		ArrayList<LinkedList<Node>> array = new ArrayList<LinkedList<Node>>();
		array.add(result);
		array.add(openlist);
		array.add(closelist);
		array.add(guide_Node);
		// Array.newInstance(LinkedList<Node>,3);
		// LinkedList<Node> result1[]= new LinkedList<Node>[3];
		return array;

	}

	// This code defines a method called equals that compares two Node objects to
	// see if they are equal.
	public boolean equals(Node a, Node b) {
		if (Node.distance(a, b) < 3) {
			return true;
		} else {
			return false;
		}
	}

	// This code defines a method called isOpen that checks whether node a is in a
	// given openlist of nodes.
	// This code defines a method called equals that compares two Node objects to
	// see if they are equal.
	public boolean isOpen(Node a, LinkedList<Node> openlist) {
		for (int i = 0; i < openlist.size(); i++) {
			if (Node.distance(openlist.get(i), a) <= 0.01) {
				return true;
			}
		}
		return false;
	}

	// This code defines a static method, isAdmissible, which determines whether a
	// given node a is within the legal region of the graph structure graph.

	public static boolean isAdmissible(Node a, Graph graph) {
		if (Graph.isInGraph(a, graph)) {
			for (int i = 0; i < graph.obstNum; i++) {
				if (graph.obst[i].getClass().equals(Rect.class)) {
					double temp[][] = Rect.Conver((Rect) graph.obst[i]);
					if (Graph.isInPolygon(a, temp)) {
						return false;
					}
				} else if (graph.obst[i].getClass().equals(Polygon.class)) {
					double temp[][] = Polygon.Conver((Polygon) graph.obst[i]);
					if (Graph.isInPolygon(a, temp)) {

						return false;
					}
				} else if (graph.obst[i].getClass().equals(Circle.class)) {
					if (Graph.isInCircle(a, (Circle) graph.obst[i])) {
						return false;
					}
				} else if (graph.obst[i].getClass().equals(Segment.class)) {
					double[][] temp = Segment.Conver((Segment) graph.obst[i]);
					if (Graph.isInSegment(a, temp)) {
						return false;
					}
				} else if (graph.obst[i].getClass().equals(ellipse.class)) {
					Rect temp = ellipse.Conver((ellipse) graph.obst[i]);
					double[][] temp1 = Rect.Conver(temp);
					if (Graph.isInPolygon(a, temp1)) {
						return false;
					}
				} else {
					System.out.println("This obstacle is not in the obstacle system.");
					System.exit(0);
				}
			}
		} else {
			return false;
		}
		return true;
	}

	// This code defines a static method isCrossAdmissible, which is used to check
	// whether a given line segment seg intersects an obstacle in the graph
	// structure graph. This method traverses the obstacle list and calls
	// corresponding methods for different types of obstacles to determine whether
	// the line segment intersects with the obstacle.
	public static boolean isCrossAdmissible(Segment seg, Graph graph) {
		for (int i = 0; i < graph.obstNum; i++) {
			if (graph.obst[i].getClass().equals(Rect.class)) {

				if (Graph.isCrossRect((Rect) graph.obst[i], seg)) {
					return false;
				}
			} else if (graph.obst[i].getClass().equals(Polygon.class)) {
				if (Graph.isCrossPolygon((Polygon) graph.obst[i], seg)) {
					return false;
				}
			} else if (graph.obst[i].getClass().equals(Circle.class)) {
				if (Graph.isCrossCircle((Circle) graph.obst[i], seg)) {
					return false;
				}
			} else if (graph.obst[i].getClass().equals(Segment.class)) {
				if (Graph.isCrossSegment((Segment) graph.obst[i], seg)) {
					return false;
				}
			} else if (graph.obst[i].getClass().equals(ellipse.class)) {
				if (Graph.isCrossEllipse((ellipse) graph.obst[i], seg)) {
					return false;
				}
			} else {
				System.out.println("This obstacle is not in the obstacle system.");
				System.exit(0);
			}
		}
		return true;
	}

	// This code implements a method based on bubbling sort for sorting an incoming
	// LinkedList<Node>. The sorting is based on the Fx and Hx properties of the
	// node.
	public static LinkedList<Node> bubbleSort(LinkedList<Node> linkedlist) {
		for (int i = 0; i < linkedlist.size() - 1; i++) {
			if (linkedlist.get(i).Fx < linkedlist.get(i + 1).Fx) {
				linkedlist.add(i + 2, linkedlist.get(i));
				linkedlist.remove(i);
			} else if (linkedlist.get(i).Fx == linkedlist.get(i + 1).Fx) {
				if (linkedlist.get(i).Hx < linkedlist.get(i + 1).Hx) {
					linkedlist.add(i + 2, linkedlist.get(i));
					linkedlist.remove(i);
				}
			} else {
				continue;
			}
		}
		return linkedlist;
	}

	// This code is similar to the previously mentioned sorting method, but takes
	// more factors into account when comparing priorities between nodes. The method
	// still uses bubbling sort, but the comparison not only includes Fx and Hx, but
	// also takes depth into account. With this sorting method, the nodes in the
	// chain table will be in order of Fx from largest to smallest, Hx from largest
	// to smallest, and depth from smallest to largest.
	public static LinkedList<Node> bubbleSort_Priority(LinkedList<Node> linkedlist) {
		for (int i = 0; i < linkedlist.size() - 1; i++) {
			if (linkedlist.get(i).Fx < linkedlist.get(i + 1).Fx) {
				linkedlist.add(i + 2, linkedlist.get(i));
				linkedlist.remove(i);
			} else if (Math.abs((linkedlist.get(i).Fx - linkedlist.get(i + 1).Fx)) < 0.1) {
				if (linkedlist.get(i).Hx < linkedlist.get(i + 1).Hx) {
					linkedlist.add(i + 2, linkedlist.get(i));
					linkedlist.remove(i);
				}
				if (Math.abs(linkedlist.get(i).Hx - linkedlist.get(i + 1).Hx) < 0.1) {
					if (linkedlist.get(i).depth > linkedlist.get(i + 1).depth)
						linkedlist.add(i + 2, linkedlist.get(i));
					linkedlist.remove(i);
				}
			} else {
				continue;
			}
		}
		return linkedlist;
	}

	// This code defines a static method findRealDepth, which accepts a node (Node)
	// as an argument and returns the actual depth of the node in the tree
	// structure. The real depth is the number of edges that pass on the path from
	// the given Node to the root node.
	public static int findRealDepth(Node node) {
		int result = 0;
		Node temp = node;
		while (temp.Father != null) {
			result = result + 1;
			temp = temp.Father;
		}
		return result;
	}

	// This code defines a static method findRealGx that accepts a node (Node) and a
	// step size parameter (StepSize) as input and returns the actual path length
	// (Gx value) from the root node to that node. The actual path length is the sum
	// of the lengths of the edges that pass on the path from a given node to the
	// root node.
	public static double findRealGx(Node node, double StepSize) {
		double distance = 0;
		Node temp = node;
		while (temp.Father != null) {
			distance = distance + StepSize;
			temp = temp.Father;
		}
		return distance;
	}

	// This code defines a method findRealTrace that accepts a node (Node) as input
	// and returns the actual path from that node to the root node. The path is
	// returned as a chained list containing all the nodes from the given Node to
	// the root node.
	public LinkedList<Node> findRealTrace(Node node) {
		LinkedList<Node> trace = new LinkedList<>();
		Node temp = node;
		while (temp.Father != null) {
			trace.addFirst(temp);
			temp = temp.Father;
		}
		trace.addFirst(temp);
		return trace;
	}

	/**
	 * A* Search algorithm in a 2D graph.
	 *
	 * @param graph            The input graph containing obstacles, start, and
	 *                         destination points.
	 * @param NumOfSearhPoints The number of search points for generating new nodes
	 *                         in each iteration.
	 * @param StepSize         The step size for creating new nodes in the search
	 *                         space.
	 * @param SearchAngle      The angle between consecutive search points for
	 *                         creating new nodes.
	 * @param angle0           The initial angle for the search direction.
	 * @return An ArrayList containing LinkedLists representing:
	 *         - The optimal path from the start to the destination (result).
	 *         - The nodes currently in the open list (openlist).
	 *         - The nodes that have been considered and removed from further
	 *         consideration (closelist).
	 *
	 *         Note: The function uses A* algorithm to find the shortest path in a
	 *         2D space, considering
	 *         obstacles and generating new nodes based on the provided parameters.
	 */
	ArrayList<LinkedList<Node>> Astar_2D(Graph graph, int NumOfSearhPoints, double StepSize, double SearchAngle,
			double angle0) {
		LinkedList<Node> openlist = new LinkedList<>();
		LinkedList<Node> closelist = new LinkedList<>();
		LinkedList<Node> result = new LinkedList<>();
		Node temp[] = new Node[NumOfSearhPoints];
		int HalfNumOfSearhPoints = 0;

		if (NumOfSearhPoints % 2 == 0) {
			System.out.println("The search times is illegal!");
			System.exit(0);
		} else {
			HalfNumOfSearhPoints = (NumOfSearhPoints - 1) / 2;
		}
		Node en = new Node(graph.en_des[0][0], graph.en_des[1][0]);
		Node des = new Node(graph.en_des[0][1], graph.en_des[1][1]);
		en.Father = null;
		en.Gx = 0;
		en.Hx = Node.distance(en, des);
		en.Fx = en.Gx + en.Hx;
		en.angle = angle0;
		openlist.add(en);
		en.isopen = true;

		// int flag = 0;
		Node best = null;

		while (openlist.size() != 0) {
			openlist = bubbleSort(openlist);
			best = openlist.getLast();
			// System.out.println("x = "+ best.x + "y = "+ best.y);
			if (equals(best, des)) {
				break;
			} else {
				openlist.remove(best);
				for (int i = -HalfNumOfSearhPoints; i <= HalfNumOfSearhPoints; i++) {
					temp[i + HalfNumOfSearhPoints] = new Node(
							best.x + StepSize * Math.cos(best.angle + i * SearchAngle),
							best.y + StepSize * Math.sin(best.angle + i * SearchAngle));
					Node a = temp[i + HalfNumOfSearhPoints];
					Segment trace = new Segment(best.x, best.y, a.x, a.y);
					if (isAdmissible(a, graph) && isCrossAdmissible(trace, graph)) {
						a.Father = best;
						a.Gx = best.Gx + StepSize;
						a.Hx = Node.distance(a, des);
						a.Fx = a.Gx + a.Hx;
						a.depth = findRealDepth(a);
						a.angle = best.angle + i * SearchAngle;
						if (!isOpen(a, openlist))
							openlist.add(a);
					}
				}
			}
			closelist.add(best);
		}

		result = findRealTrace(best);
		ArrayList<LinkedList<Node>> array = new ArrayList<LinkedList<Node>>();
		array.add(result);
		array.add(openlist);
		array.add(closelist);
		// Array.newInstance(LinkedList<Node>,3);
		// LinkedList<Node> result1[]= new LinkedList<Node>[3];
		return array;
	}

	/**
	 * A* Search algorithm in a 2D graph considering node depth as a priority.
	 *
	 * @param graph            The input graph containing obstacles, start, and
	 *                         destination points.
	 * @param NumOfSearhPoints The number of search points for generating new nodes
	 *                         in each iteration.
	 * @param StepSize         The step size for creating new nodes in the search
	 *                         space.
	 * @param SearchAngle      The angle between consecutive search points for
	 *                         creating new nodes.
	 * @param angle0           The initial angle for the search direction.
	 * @return An ArrayList containing LinkedLists representing:
	 *         - The optimal path from the start to the destination (result).
	 *         - The nodes currently in the open list (openlist).
	 *         - The nodes that have been considered and removed from further
	 *         consideration (closelist).
	 *
	 *         Note: The function uses A* algorithm to find the shortest path in a
	 *         2D space, considering
	 *         obstacles and generating new nodes based on the provided parameters.
	 *         In this version,
	 *         the search prioritizes nodes based on their depth in the tree (number
	 *         of nodes in the path).
	 */
	ArrayList<LinkedList<Node>> Astar_2D_Depth(Graph graph, int NumOfSearhPoints, double StepSize, double SearchAngle,
			double angle0) {
		LinkedList<Node> openlist = new LinkedList<>();
		LinkedList<Node> closelist = new LinkedList<>();
		LinkedList<Node> result = new LinkedList<>();
		Node temp[] = new Node[NumOfSearhPoints];
		int HalfNumOfSearhPoints = 0;

		if (NumOfSearhPoints % 2 == 0) {
			System.out.println("The search times is illegal!");
			System.exit(0);
		} else {
			HalfNumOfSearhPoints = (NumOfSearhPoints - 1) / 2;
		}
		Node en = new Node(graph.en_des[0][0], graph.en_des[1][0]);
		Node des = new Node(graph.en_des[0][1], graph.en_des[1][1]);
		en.Father = null;
		en.Gx = 0;
		en.Hx = Node.distance(en, des);
		en.Fx = en.Gx + en.Hx;
		en.angle = angle0;
		openlist.add(en);
		en.isopen = true;

		// int flag = 0;
		Node best = null;

		while (openlist.size() != 0) {
			openlist = bubbleSort_Priority(openlist);
			best = openlist.getLast();
			// System.out.println("x = "+ best.x + "y = "+ best.y);
			if (equals(best, des)) {
				break;
			} else {
				openlist.remove(best);
				for (int i = -HalfNumOfSearhPoints; i <= HalfNumOfSearhPoints; i++) {
					temp[i + HalfNumOfSearhPoints] = new Node(
							best.x + StepSize * Math.cos(best.angle + i * SearchAngle),
							best.y + StepSize * Math.sin(best.angle + i * SearchAngle));
					Node a = temp[i + HalfNumOfSearhPoints];
					Segment trace = new Segment(best.x, best.y, a.x, a.y);
					if (isAdmissible(a, graph) && isCrossAdmissible(trace, graph)) {
						a.Father = best;
						a.Gx = best.Gx + StepSize;
						a.Hx = Node.distance(a, des);
						a.Fx = a.Gx + a.Hx;
						a.depth = findRealDepth(a);
						a.angle = best.angle + i * SearchAngle;
						if (!isOpen(a, openlist))
							openlist.add(a);
					}
				}
			}
			closelist.add(best);
		}

		result = findRealTrace(best);
		ArrayList<LinkedList<Node>> array = new ArrayList<LinkedList<Node>>();
		array.add(result);
		array.add(openlist);
		array.add(closelist);
		// Array.newInstance(LinkedList<Node>,3);
		// LinkedList<Node> result1[]= new LinkedList<Node>[3];
		return array;
	}

	@Override
	ArrayList<LinkedList<Node>> Astar_2D(Graph graph, int NumOfSearhPoints, double StepSize, double SearchAngle) {
		// TODO Auto-generated method stub
		return null;
	}

}