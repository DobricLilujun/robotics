/**
 * Represents a node in a 2D space with coordinates (x, y).
 */
public class Node {
	public double x;
	public double y;
	public double fx;
	public double gx;
	public double hx;
	public double Fx;
	public double Gx;
	public double Hx;
	public int depth;
	public Node Father;
	double angle;
	public boolean isopen;
	public boolean isclose;
	public boolean isobstacle;

	/**
	 * Constructs a new Node with the specified coordinates (x, y).
	 *
	 * @param x The X-coordinate of the node.
	 * @param y The Y-coordinate of the node.
	 */
	public Node(double x, double y) {
		this.x = x;
		this.y = y;
		this.isopen = false;
		this.isclose = false;
	}

	/**
	 * Calculates the cross product of vectors AB and AC.
	 *
	 * @param A The starting point of vector AB.
	 * @param B The ending point of vector AB and starting point of vector AC.
	 * @param C The ending point of vector AC.
	 * @return The cross product of vectors AB and AC.
	 */
	public static double cross_product(Node A, Node B, Node C) {

		double cross1 = (C.x - A.x) * (B.y - A.y);
		double cross2 = (C.y - A.y) * (B.x - A.x);
		return (cross1 - cross2);

	}

	/**
	 * Calculates the cross product of vectors a and b.
	 *
	 * @param a The first vector.
	 * @param b The second vector.
	 * @return The cross product of vectors a and b.
	 */
	public static double cross_product(Node a, Node b) {

		return (a.x * b.y - a.y * b.x);

	}

	/**
	 * Calculates the Euclidean distance between two nodes p and p1.
	 *
	 * @param p  The first node.
	 * @param p1 The second node.
	 * @return The Euclidean distance between nodes p and p1.
	 */
	public static double distance(Node p, Node p1) {
		return Math.hypot(p.x - p1.x, p.y - p1.y);
	}

}