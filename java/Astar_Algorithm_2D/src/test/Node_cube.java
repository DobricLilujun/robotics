package test;

public class Node_cube 
{
	public int x;
	public int y;
	public double fx;
	public double gx;
	public double hx;
	public double Fx;
	public double Gx;
	public double Hx;
	public Node_cube Father;
	public boolean isopen;
	public boolean isclose;
	public boolean isobstacle;

	public Node_cube(int x,int y)
	{
		if (x>=0)
		{
			this.x = x;
		}
		else
		{
			System.out.println("This Node_cube'coordinate is not in the graph.");
			System.exit(-1);
		}
		if (y>=0)
		{
			this.y = y;
		}
		else
		{
			System.out.println("This Node_cube'coordinate is not in the graph.");
			System.exit(-1);
		}
		this.isopen = false;
		this.isclose = false;
	}

}
