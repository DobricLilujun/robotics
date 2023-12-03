
public class Graph 
{
	public double x0;
	public double y0;
	public double  xlength;
	public double  ylength;
	public int obstNum;
	public double en_des[][] = new double[2][2];
	public Object [] obst; 
	
	public Graph(double x0,double y0,double xlength,double ylength,Object[] obst,double en_des[][])
	{
		this.x0 = x0;
		this.y0 = y0;
		this.xlength = xlength;
		this.ylength = ylength;
		this.obst =obst;
		this.obstNum = obst.length;	
		this.en_des = en_des;
	}
	
//	public Graph(double x0,double y0,double xlength,double ylength,Object[] obst,double en_des[][],boolean isChev)
//	{
//		if(isChev == true)
//		{
//			this.x0 = x0;
//			this.y0 = y0;
//			this.xlength = xlength;
//			this.ylength = ylength;
//			this.obst =obst;
//			this.obstNum = obst.length;	
//			this.en_des = en_des;
//		}
//		else
//		{
//			System.out.println("This constructor function can only be Chev!");
//			System.exit(0);
//		}
//	}

	public static boolean isInGraph(Node a,Graph graph)						
	{
		if(((a.x<=graph.x0+graph.xlength)&&(a.x>=graph.x0))&&((a.y<=graph.y0+graph.ylength)&&(a.y>=graph.y0)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isInCircle(Node a,Circle c)
	{
		Node temp = new Node(c.x,c.y);
		if(Node.distance(a,temp)<=c.r)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isInSegment(Node a,double points[][])				
		
	{
		Node temp1 = new Node(points[0][0]-a.x,points[1][0]-a.y);
		Node temp2 = new Node(points[0][1]-a.x,points[1][1]-a.y);
		double length_x = Math.abs(points[0][1]-points[0][0]);
		double length_y = Math.abs(points[1][1]-points[1][0]);
		if(Node.cross_product(temp1, temp2)==0)
		{
			if((Math.abs(points[0][0]-a.x)+Math.abs(points[0][1]-a.x))==(length_x))
			{
				if((Math.abs(points[1][0]-a.y)+Math.abs(points[1][1]-a.y))==(length_y))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isInPolygon(Node a,double points[][])				
	{
		int crossings = 0;
		if(points[0].length<3)
		{
			System.out.println("The points you input can't be a Polygon");
			System.exit(0);
		}
		double temp_points[][] = new double[2][points[0].length+3];
		double segment[][] = new double[2][2];
		for (int i = 0 ; i< points[0].length;i++)
		{
			temp_points[0][i] = points[0][i];
			temp_points[1][i] = points[1][i];
		}
		
		temp_points[0][points[0].length]   = points[0][0];
		temp_points[1][points[0].length]   = points[1][0];
		temp_points[0][points[0].length+1] = points[0][1];
		temp_points[1][points[0].length+1] = points[1][1];
		temp_points[0][points[0].length+2] = points[0][2];
		temp_points[1][points[0].length+2] = points[1][2];			
		
		for (int i = 0 ; i< points[0].length;i++)
		{
			segment[0][0] = temp_points[0][i];
			segment[1][0] = temp_points[1][i];
			segment[0][1] = temp_points[0][i+1];
			segment[1][1] = temp_points[1][i+1];
			if(isInSegment(a,segment))
			{
				return true;
			}
		}
		for(int i=0;i<points[0].length;i++)							
		{
//			System.out.println("i am here");
//			System.out.println(crossings);
			if(temp_points[0][i+1]==temp_points[0][i])														
			{
				if(a.x == temp_points[0][i])
				{
					if(i == 0)
					{
						boolean left  =  (temp_points[0][points[0].length-1]<a.x);
						boolean right =  (temp_points[0][2]<a.x);
						if(left == true)
						{
							crossings++;
						}
						if(right == true)
						{
							crossings++;
						}
					}
					else
					{
						boolean left  =  (temp_points[0][i-1]<a.x);
						boolean right =  (temp_points[0][i+2]<a.x);
						if(left == true)
						{
							crossings++;
						}
						if(right == true)
						{
							crossings++;
						}
					}
				}
			}
			else
			{
				double slope = (temp_points[1][i+1]-temp_points[1][i])/(temp_points[0][i+1]-temp_points[0][i]);//求两个线段斜率
				if(((temp_points[0][i]<a.x)&&(a.x<temp_points[0][i+1]))||((temp_points[0][i+1]< a.x)&&(a.x<temp_points[0][i])))
				{
					if(a.y < slope*(a.x - temp_points[0][i])+temp_points[1][i])
					{
						crossings++;
					}
				}
				if(temp_points[0][i] == a.x)
				{
					if(i==0)
					{
						boolean right =  (temp_points[0][2]<a.x);
						if(right == true)
						{
							crossings++;
						}
					}
					else
					{
						boolean right =  (temp_points[0][i+1]<a.x);
						if(right == true)
						{
							if(temp_points[0][i]!=temp_points[0][i-1])
							crossings++;
						}
					}
				}
				if(temp_points[0][i+1] == a.x)
				{
					boolean left  =  (temp_points[0][i]<a.x);
					if(left == true)
					{
						if(temp_points[0][i+1]!=temp_points[0][i+2])
						crossings++;
					}
				}
			}

		}
//		System.out.println("times: "+ crossings);
		if(crossings%2 == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean isCrossSegment(double seg1[][],double seg2[][])	
	{

//			Node a = new Node(seg1[0][0]-seg2[0][0],seg1[1][0]-seg2[1][0]);
//			Node b = new Node(seg2[0][1]-seg2[0][0],seg2[1][1]-seg2[1][0]);
//			Node c = new Node(seg1[0][1]-seg2[0][0],seg1[1][1]-seg2[1][0]);
			Node A1 = new Node(seg1[0][0],seg1[1][0]);
			Node A2 = new Node(seg1[0][1],seg1[1][1]);
			Node B1 = new Node(seg2[0][0],seg2[1][0]);
			Node B2 = new Node(seg2[0][1],seg2[1][1]);
			double T1 = Node.cross_product(A1, A2, B1);
			double T2 = Node.cross_product(A1, A2, B2);
			double T3 = Node.cross_product(B1, B2, A1);
			double T4 = Node.cross_product(B1, B2, A2);
			if( ((T1*T2) > 0) || ((T3*T4) > 0) )
			{
				return false;
			}
			else if((T1 == 0) && (T2 == 0))
			{
												
				if ( Math.min(A1.y, A2.y) <= Math.max(B1.y, B2.y) && Math.max(A1.y, A2.y) >= Math.min(B1.y, B2.y) &&
				     Math.min(A1.x, A2.x) <= Math.max(B1.x, B2.x) && Math.max(A1.x, A2.x) >= Math.min(B1.x, B2.x)
				   ) 
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return true;
			}
	}
	
	public static boolean isCrossSegment(Segment seg1,Segment seg2)	
	{

//			Node a = new Node(seg1[0][0]-seg2[0][0],seg1[1][0]-seg2[1][0]);
//			Node b = new Node(seg2[0][1]-seg2[0][0],seg2[1][1]-seg2[1][0]);
//			Node c = new Node(seg1[0][1]-seg2[0][0],seg1[1][1]-seg2[1][0]);
			Node A1 = new Node(seg1.x1,seg1.y1);
			Node A2 = new Node(seg1.x2,seg1.y2);
			Node B1 = new Node(seg2.x1,seg2.y1);
			Node B2 = new Node(seg2.x2,seg2.y2);
			double T1 = Node.cross_product(A1, A2, B1);
			double T2 = Node.cross_product(A1, A2, B2);
			double T3 = Node.cross_product(B1, B2, A1);
			double T4 = Node.cross_product(B1, B2, A2);
			if( ((T1*T2) > 0) || ((T3*T4) > 0) )
			{
				return false;
			}
			else if((T1 == 0) && (T2 == 0))
			{
												
				if ( Math.min(A1.y, A2.y) <= Math.max(B1.y, B2.y) && Math.max(A1.y, A2.y) >= Math.min(B1.y, B2.y) &&
				     Math.min(A1.x, A2.x) <= Math.max(B1.x, B2.x) && Math.max(A1.x, A2.x) >= Math.min(B1.x, B2.x)
				   ) 
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return true;
			}
	}
	
	public static double  minDistance(Node point,Segment L)					
	{
		double distance_min = 0;
		
	    double a, b, c;
	    Node p1 = new Node(L.x1,L.y1);
	    Node p2 = new Node(L.x2,L.y2);
	    Node p  = new Node(point.x,point.y);
	    a = Node.distance(p1, p2);
	    b = Node.distance(p1, p);
	    c = Node.distance(p2, p);
	    if (c+b==a) 
	    {
	    	distance_min = 0;
	    }
	    
	    else if (a<=0.00001) 
	    {
	    	distance_min = b;
	    }
	    
	    else if (c*c >= a*a + b*b) { 
	    	distance_min = b;
	    }
	    
	    else if (b * b >= a * a + c * c) 
	    {
	    	distance_min = c;
	    }
	    else
	    {
		    
		    double p0 = (a + b + c) / 2;
		    double s = Math.sqrt(p0 * (p0 - a) * (p0 - b) * (p0 - c));
		    distance_min = 2*s / a;
	    }
	    return distance_min;
	}
	
	public static boolean isCrossCircle(Circle C,Segment L)					
	{
		Node point = new Node (C.x,C.y);
	
		double distance_min = minDistance(point,L);
	    if(distance_min-C.r>0.01)
	    {
	    	return false;
	    }
	    else
	    {
	    	return true;
	    }
	}
	
	public static boolean isCrossPolygon(Polygon P,Segment L)
	{
		double temp[][] = new double[2][P.Points[0].length+1];
		double L_1[][] = {{L.x1,L.x2},{L.y1,L.y2}};
		for(int i = 0 ; i < P.Points[0].length;i++)
		{
			temp[0][i] = P.Points[0][i];
			temp[1][i] = P.Points[1][i];
		}
		temp[0][ P.Points[0].length] = P.Points[0][0];
		temp[1][ P.Points[0].length] = P.Points[1][0];
		for(int i = 0 ; i < P.Points[0].length;i++)
		{
			double [][] temp_1 = {{temp[0][i],temp[0][i+1]},{temp[1][i],temp[1][i+1]}};
			if(Graph.isCrossSegment(temp_1,L_1))
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean isCrossRect(Rect P,Segment L)
	{
		double temp[][] = new double[2][5];
		double L_1[][] = {{L.x1,L.x2},{L.y1,L.y2}};
		double P_1[][] = Rect.Conver(P) ;
		for(int i = 0 ; i < 4;i++)
		{
			temp[0][i] = P_1[0][i];
			temp[1][i] = P_1[1][i];
		}
		
		temp[0][4] = P_1[0][0];
		temp[1][4] = P_1[1][0];
		
		for(int i = 0;i< 4;i++)
		{
			double [][] temp_1 = {{temp[0][i],temp[0][i+1]},{temp[1][i],temp[1][i+1]}};
			if(Graph.isCrossSegment(temp_1,L_1))
			{
				
				return true;
			}
		}

		return false;
	}
	
	
	public static boolean isCrossEllipse(ellipse C,Segment L)					
	{
		Rect temp= ellipse.Conver(C);
		Polygon temp2 = new Polygon(Rect.Conver(temp));
 		
	    if(Graph.isCrossPolygon(temp2,L))
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}
}




