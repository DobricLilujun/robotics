package test;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

// Astar class extending Algorithm
public class Astar extends Algorithm {

	// Method to check if two nodes are equal
	public boolean equals(Node a, Node b) {
		if ((a.x == b.x) && (a.y == b.y)) {
			return true;
		} else {
			return false;
		}
	}

	// Method to check if a given position is admissible on the graph
	public static boolean isAdmissible(int x0, int y0, Graph graph) {
		if ((x0 < 0) || (x0 >= graph.xlength) || (y0 < 0) || (y0 >= graph.ylength)) {
			return false;
		} else if (graph.members[x0][y0].isobstacle == true) {
			return false;
		} else if (graph.members[x0][y0].isclose == true) {
			return false;
		} else {
			return true;
		}
	}

	// Method to perform bubble sort on a linked list based on Manhattan distance
	public static LinkedList<Node> bubbleSort_M(LinkedList<Node> linkedlist) {
		for (int i = 0; i < linkedlist.size() - 1; i++) {
			if (linkedlist.get(i).fx < linkedlist.get(i + 1).fx) {
				linkedlist.add(i + 2, linkedlist.get(i));
				linkedlist.remove(i);
			} else if (linkedlist.get(i).fx == linkedlist.get(i + 1).fx) {
				if (linkedlist.get(i).hx < linkedlist.get(i + 1).hx) {
					linkedlist.add(i + 2, linkedlist.get(i));
					linkedlist.remove(i);
				}
			} else {
				continue;
			}
		}
		return linkedlist;
	}

	// Method to perform bubble sort on a linked list based on Chebyshev distance
	public static LinkedList<Node> bubbleSort_C(LinkedList<Node> linkedlist) {
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

	static void extend(LinkedList<Node> openlist) {

	}

	// Method to find the real Gx value for a given node
	public static double findRealGx(Node node) {
		double distance = 0;
		Node temp = node;
		while (temp.Father != null) {
			if (Math.abs(temp.x - temp.Father.x) + Math.abs(temp.y - temp.Father.y) == 2) {
				distance = distance + 14;
			} else if (Math.abs(temp.x - temp.Father.x) + Math.abs(temp.y - temp.Father.y) == 1) {
				distance = distance + 10;
			} else {
				System.out.println("the trace is not OK");
			}
			temp = temp.Father;
		}
		return distance;
	}

	// Method to find the real trace of a given node
	public LinkedList<Node> findRealTrace(Node node) {
		LinkedList<Node> trace = new LinkedList<>();
		Node temp = node;
		while (temp.Father != null) {
			trace.addFirst(temp);
			temp = temp.Father;
		}
		return trace;
	}

	// A* algorithm implementation using Manhattan distance
	ArrayList<LinkedList<Node>> Astar_Manhattan(Graph graph) {
		LinkedList<Node> openlist = new LinkedList<>();
		LinkedList<Node> closelist = new LinkedList<>();
		LinkedList<Node> result = new LinkedList<>();
		openlist.add(graph.members[graph.en_des[0][0]][graph.en_des[1][0]]);
		graph.members[graph.en_des[0][0]][graph.en_des[1][0]].isopen = true;

		Node best;
		int x;
		int y;

		while (openlist.size() != 0) {
			openlist = bubbleSort_M(openlist);
			// for(int i = 0 ; i< openlist.size();i++)
			// {
			// System.out.println("x ="+ openlist.get(i).x+"y ="+
			// openlist.get(i).y+"Fx="+openlist.get(i).fx);
			// }
			// System.out.println("THE"+j+"th"+"iteration");
			// j++;
			best = openlist.getLast();
			x = best.x;
			y = best.y;
			if (equals(best, graph.members[graph.en_des[0][1]][graph.en_des[1][1]])) {
				break;
			} else {
				if (isAdmissible(x, y + 1, graph)) {

					if (!graph.members[x][y + 1].isopen) {
						graph.members[x][y + 1].Father = best;
						graph.members[x][y + 1].gx = findRealGx(graph.members[x][y + 1]);
						graph.members[x][y + 1].fx = graph.members[x][y + 1].gx + graph.members[x][y + 1].hx;
						openlist.add(graph.members[x][y + 1]);
						graph.members[x][y + 1].isopen = true;
					} else {
						double gx_new = findRealGx(best) + 10;
						double fx_new = gx_new + graph.members[x][y + 1].hx;
						if (fx_new < graph.members[x][y + 1].fx) {
							graph.members[x][y + 1].Father = best;
						}
					}
				}
				if (isAdmissible(x, y - 1, graph)) {

					if (!graph.members[x][y - 1].isopen) {
						graph.members[x][y - 1].Father = best;
						graph.members[x][y - 1].gx = findRealGx(graph.members[x][y - 1]);
						graph.members[x][y - 1].fx = graph.members[x][y - 1].gx + graph.members[x][y - 1].hx;
						openlist.add(graph.members[x][y - 1]);
						graph.members[x][y - 1].isopen = true;
					} else {
						double gx_new = findRealGx(best) + 10;
						double fx_new = gx_new + graph.members[x][y - 1].hx;
						if (fx_new < graph.members[x][y - 1].fx) {
							graph.members[x][y - 1].Father = best;
						}
					}
				}
				if (isAdmissible(x + 1, y, graph)) {
					if (!graph.members[x + 1][y].isopen) {
						graph.members[x + 1][y].Father = best;
						graph.members[x + 1][y].gx = findRealGx(graph.members[x + 1][y]);
						graph.members[x + 1][y].fx = graph.members[x + 1][y].gx + graph.members[x + 1][y].hx;
						openlist.add(graph.members[x + 1][y]);
						graph.members[x + 1][y].isopen = true;
					} else {
						double gx_new = findRealGx(best) + 10;
						double fx_new = gx_new + graph.members[x + 1][y].hx;
						if (fx_new < graph.members[x + 1][y].fx) {
							graph.members[x + 1][y].Father = best;
						}
					}
				}
				if (isAdmissible(x - 1, y, graph)) {
					if (!graph.members[x - 1][y].isopen) {
						graph.members[x - 1][y].Father = best;
						graph.members[x - 1][y].gx = findRealGx(graph.members[x - 1][y]);
						graph.members[x - 1][y].fx = graph.members[x - 1][y].gx + graph.members[x - 1][y].hx;
						openlist.add(graph.members[x - 1][y]);
						graph.members[x - 1][y].isopen = true;
					} else {
						double gx_new = findRealGx(best) + 10;
						double fx_new = gx_new + graph.members[x - 1][y].hx;
						if (fx_new < graph.members[x - 1][y].fx) {
							graph.members[x - 1][y].Father = best;
						}
					}
				}
			}

		}
		// Object result1 = (LinkedList<Node>) new Object[3];
		ArrayList<LinkedList<Node>> array = new ArrayList<LinkedList<Node>>();
		result = findRealTrace(graph.members[graph.en_des[0][1]][graph.en_des[1][1]]);
		array.add(result);
		array.add(openlist);
		array.add(closelist);
		// result1[0] = result;

		return array;
	}

	// A* algorithm implementation using Chebyshev distance
	public ArrayList<LinkedList<Node>> Astar_Chebyshev(Graph graph) {
		LinkedList<Node> openlist = new LinkedList<>();
		LinkedList<Node> closelist = new LinkedList<>();
		LinkedList<Node> result = new LinkedList<>();
		openlist.add(graph.members[graph.en_des[0][0]][graph.en_des[1][0]]);
		graph.members[graph.en_des[0][0]][graph.en_des[1][0]].isopen = true;

		Node best;
		int x;
		int y;
		while (openlist.size() != 0) {
			openlist = bubbleSort_C(openlist);
			best = openlist.getLast();
			x = best.x;
			y = best.y;
			// System.out.println("x:"+x+"y: "+y);
			// System.out.println(closelist.size());
			closelist.add(best);
			// System.out.println(closelist.size());
			best.isclose = true;
			openlist.remove(best);
			best.isopen = false;
			if (equals(best, graph.members[graph.en_des[0][1]][graph.en_des[1][1]])) {
				break;

			} else {
				// 1////////////////////////////////////////////////////////////////////////////////////////
				if (isAdmissible(x, y + 1, graph)) {

					if (!graph.members[x][y + 1].isopen) {
						graph.members[x][y + 1].Father = best;
						graph.members[x][y + 1].Gx = findRealGx(graph.members[x][y + 1]);
						graph.members[x][y + 1].Fx = graph.members[x][y + 1].Gx + graph.members[x][y + 1].Hx;
						openlist.add(graph.members[x][y + 1]);
						graph.members[x][y + 1].isopen = true;
					} else {
						double gx_new = findRealGx(best) + 10;
						double fx_new = gx_new + graph.members[x][y + 1].Hx;
						if (fx_new < graph.members[x][y + 1].Fx) {
							graph.members[x][y + 1].Father = best;
						}
					}
				}
				// 2///////////////////////////////////////////////////////////////////////////////////////
				if (isAdmissible(x, y - 1, graph)) {

					if (!graph.members[x][y - 1].isopen) {
						graph.members[x][y - 1].Father = best;
						graph.members[x][y - 1].Gx = findRealGx(graph.members[x][y - 1]);
						graph.members[x][y - 1].Fx = graph.members[x][y - 1].Gx + graph.members[x][y - 1].Hx;
						openlist.add(graph.members[x][y - 1]);
						graph.members[x][y - 1].isopen = true;
					} else {
						double gx_new = findRealGx(best) + 10;
						;
						double fx_new = gx_new + graph.members[x][y - 1].Hx;
						if (fx_new < graph.members[x][y - 1].Fx) {
							graph.members[x][y - 1].Father = best;
						}
					}
				}
				// 3///////////////////////////////////////////////////////////////////////////////////////
				if (isAdmissible(x + 1, y, graph)) {
					if (!graph.members[x + 1][y].isopen) {
						graph.members[x + 1][y].Father = best;
						graph.members[x + 1][y].Gx = findRealGx(graph.members[x + 1][y]);
						graph.members[x + 1][y].Fx = graph.members[x + 1][y].Gx + graph.members[x + 1][y].Hx;
						openlist.add(graph.members[x + 1][y]);
						graph.members[x + 1][y].isopen = true;
					} else {
						double gx_new = findRealGx(best) + 10;
						double fx_new = gx_new + graph.members[x + 1][y].Hx;
						if (fx_new < graph.members[x + 1][y].Fx) {
							graph.members[x + 1][y].Father = best;
						}
					}
				}
				// 4///////////////////////////////////////////////////////////////////////////////////////
				if (isAdmissible(x - 1, y, graph)) {
					if (!graph.members[x - 1][y].isopen) {
						graph.members[x - 1][y].Father = best;
						graph.members[x - 1][y].Gx = findRealGx(graph.members[x - 1][y]);
						graph.members[x - 1][y].Fx = graph.members[x - 1][y].Gx + graph.members[x - 1][y].Hx;
						openlist.add(graph.members[x - 1][y]);
						graph.members[x - 1][y].isopen = true;
					} else {
						double gx_new = findRealGx(best) + 10;
						double fx_new = gx_new + graph.members[x - 1][y].Hx;
						if (fx_new < graph.members[x - 1][y].Fx) {
							graph.members[x - 1][y].Father = best;
						}
					}
				}
				// 5///////////////////////////////////////////////////////////////////////////////////////
				if (isAdmissible(x + 1, y + 1, graph)) {
					if (!((graph.members[x][y + 1].isobstacle == true)
							&& (graph.members[x + 1][y].isobstacle == true))) {
						if (!graph.members[x + 1][y + 1].isopen) {
							graph.members[x + 1][y + 1].Father = best;
							graph.members[x + 1][y + 1].Gx = findRealGx(graph.members[x + 1][y + 1]);
							graph.members[x + 1][y + 1].Fx = graph.members[x + 1][y + 1].Gx
									+ graph.members[x + 1][y + 1].Hx;
							openlist.add(graph.members[x + 1][y + 1]);
							graph.members[x + 1][y + 1].isopen = true;
						} else {
							double gx_new = findRealGx(best) + 14;
							double fx_new = gx_new + graph.members[x + 1][y + 1].Hx;
							if (fx_new < graph.members[x + 1][y + 1].Fx) {
								graph.members[x + 1][y + 1].Father = best;
							}
						}
					}
				}
				// 6///////////////////////////////////////////////////////////////////////////////////////
				if (isAdmissible(x - 1, y - 1, graph)) {
					if (!((graph.members[x - 1][y].isobstacle == true)
							&& (graph.members[x][y - 1].isobstacle == true))) {
						if (!graph.members[x - 1][y - 1].isopen) {
							graph.members[x - 1][y - 1].Father = best;
							graph.members[x - 1][y - 1].Gx = findRealGx(graph.members[x - 1][y - 1]);
							graph.members[x - 1][y - 1].Fx = graph.members[x - 1][y - 1].Gx
									+ graph.members[x - 1][y - 1].Hx;
							openlist.add(graph.members[x - 1][y - 1]);
							graph.members[x - 1][y - 1].isopen = true;
						} else {
							double gx_new = findRealGx(best) + 14;
							double fx_new = gx_new + graph.members[x - 1][y - 1].Hx;
							if (fx_new < graph.members[x - 1][y - 1].Fx) {
								graph.members[x - 1][y - 1].Father = best;
							}
						}
					}
				}
				// 7///////////////////////////////////////////////////////////////////////////////////////
				if (isAdmissible(x + 1, y - 1, graph)) {
					if (!((graph.members[x + 1][y].isobstacle == true)
							&& (graph.members[x][y - 1].isobstacle == true))) {
						if (!graph.members[x + 1][y - 1].isopen) {
							graph.members[x + 1][y - 1].Father = best;
							graph.members[x + 1][y - 1].Gx = findRealGx(graph.members[x + 1][y - 1]);
							graph.members[x + 1][y - 1].Fx = graph.members[x + 1][y - 1].Gx
									+ graph.members[x + 1][y - 1].Hx;
							openlist.add(graph.members[x + 1][y - 1]);
							graph.members[x + 1][y - 1].isopen = true;
						} else {
							double gx_new = findRealGx(best) + 14;
							double fx_new = gx_new + graph.members[x + 1][y - 1].Hx;
							if (fx_new < graph.members[x + 1][y - 1].Fx) {
								graph.members[x + 1][y - 1].Father = best;
							}
						}
					}
				}
				// 8///////////////////////////////////////////////////////////////////////////////////////
				if (isAdmissible(x - 1, y + 1, graph)) {
					if (!((graph.members[x - 1][y].isobstacle == true)
							&& (graph.members[x][y + 1].isobstacle == true))) {
						if (!graph.members[x - 1][y + 1].isopen) {
							graph.members[x - 1][y + 1].Father = best;
							graph.members[x - 1][y + 1].Gx = findRealGx(graph.members[x - 1][y + 1]);
							graph.members[x - 1][y + 1].Fx = graph.members[x - 1][y + 1].Gx
									+ graph.members[x - 1][y + 1].Hx;
							openlist.add(graph.members[x - 1][y + 1]);
							graph.members[x - 1][y + 1].isopen = true;
						} else {
							double gx_new = findRealGx(best) + 14;
							double fx_new = gx_new + graph.members[x - 1][y + 1].Hx;
							if (fx_new < graph.members[x - 1][y + 1].Fx) {
								graph.members[x - 1][y + 1].Father = best;
							}
						}
					}
				}
			}

		}
		result = findRealTrace(graph.members[graph.en_des[0][1]][graph.en_des[1][1]]);
		ArrayList<LinkedList<Node>> array = new ArrayList<LinkedList<Node>>();
		array.add(result);
		array.add(openlist);
		array.add(closelist);
		// Array.newInstance(LinkedList<Node>,3);
		// LinkedList<Node> result1[]= new LinkedList<Node>[3];
		return array;
	}

	void Astar_Euclidean(Graph graph) {

	}
}
