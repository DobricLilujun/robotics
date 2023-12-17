package test;

public class Node {
	public int x;
	public int y;
	public double fx;
	public double gx;
	public double hx;
	public double Fx;
	public double Gx;
	public double Hx;
	public Node Father;
	public boolean isopen;
	public boolean isclose;
	public boolean isobstacle;

	public Node(int x, int y) {
		if (x >= 0) {
			this.x = x;
		} else {
			System.out.println("This node'coordinate is not in the graph.");
			System.exit(-1);
		}
		if (y >= 0) {
			this.y = y;
		} else {
			System.out.println("This node'coordinate is not in the graph.");
			System.exit(-1);
		}
		this.isopen = false;
		this.isclose = false;
	}

}
