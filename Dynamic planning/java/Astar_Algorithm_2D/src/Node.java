
public class Node 
{
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

	public Node(double x,double y)
	{
		this.x = x;
		this.y = y;
		this.isopen = false;
		this.isclose = false;
	}
	public static double cross_product(Node A,Node B,Node C)
	{
		
		double cross1 = (C.x - A.x) * (B.y - A.y);
	    double cross2 = (C.y - A.y) * (B.x - A.x);
	    return (cross1 - cross2);
		
	}

	public static double cross_product(Node a,Node b)
	{
		
		return (a.x*b.y-a.y*b.x);
		
	}
	
	public static double distance(Node p, Node p1) 	
	{
	    return Math.hypot(p.x-p1.x, p.y-p1.y);
	}

}