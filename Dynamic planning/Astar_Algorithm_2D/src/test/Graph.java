package test;

public class Graph 
{
	public int xlength;
	public int ylength;
	public int obstNum;
	public int obsts [][] = new int[2][obstNum];
	public int en_des[][] = new int[2][2];
	public Node_cube members [][] = new Node_cube [xlength][ylength];
	
	public Graph(int xlength,int ylength,int obsts[][],int en_des[][])
	{
		Node_cube members [][] = new Node_cube [xlength][ylength];
		this.xlength = xlength;
		this.ylength = ylength;
		
		for(int i = 0;i < xlength; i++)
		{
			for (int j = 0;j < ylength; j++)
			{  
				members[i][j] = new Node_cube(i,j);
			}
		}
		this.members = members;
		
		
		if(obsts[0].length<xlength*ylength)
		{
			this.obstNum  = obsts[0].length;
		}
		else
		{
			System.out.println("Obstacles are more than Node_cubes in the graph.This graph cann't be drawn.");
			System.exit(-1);
		}
		for(int i = 0;i < xlength; i++)
		{
			for (int j = 0;j < ylength; j++)
			{  
				int x0 = en_des[0][0];
				int y0 = en_des[1][0];
				int x1 = en_des[0][1];
				int y1 = en_des[1][1];
				
				this.members[i][j].hx  = (Math.abs(i-x1)+Math.abs(j-y1))*10;
				this.members[i][j].gx  = (Math.abs(i-x0)+Math.abs(j-y0))*10;
				this.members[i][j].fx  = this.members[i][j].hx+this.members[i][j].gx;
				this.members[i][j].Hx  = (Math.max(Math.abs(i-x1),Math.abs(j-y1)))*10;
				this.members[i][j].Gx  = (Math.max(Math.abs(i-x0),Math.abs(j-y0)))*10;
				this.members[i][j].Fx  = this.members[i][j].Hx+this.members[i][j].Gx;
			}
		}
		for(int i =0;i< obsts[0].length;i++)
		{
			if(((obsts[0][i] < xlength)&&(obsts[0][i] >=0))&&(obsts[1][i] < ylength)&&((obsts[1][i]>=0)))
			{ 
				this.members[obsts[0][i]][obsts[1][i]].isobstacle =true;
			}
		}
		
		this.en_des = en_des;
		this.members[en_des[0][0]][en_des[1][0]].Father = null;


	
}
}
