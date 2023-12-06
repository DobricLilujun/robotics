import java.util.ArrayList;
import java.util.LinkedList;
//import Manhattan distance;

public class Main extends Astar
{

	public static void main(String []args)
	{
		
		double en_des[][] = {{99,10},{99,10}};
//		double en_des1[][] = {{99,10},{99,10}};
//		double en_des2[][] = {{99,10},{99,10}};
//		double en_des3[][] = {{99,10},{99,10}};
		double x0=0;
		double y0=0;
		double xlength=100;
		double ylength=100;
		int obstNum = 0;
		
		Object[] obst = new Object[obstNum];
//		Circle 	b  =  new Circle(20,10,10);
//		obst[0] = b ;
//		
//		Circle 	c  =  new Circle(50,90,10);
//		obst[0] = c ;
//		Circle 	c  =  new Circle(50,40,10);
//		obst[1] = c ;
//		Circle 	d  =  new Circle(30,20,20);
//		obst[1] = d ;
//		ellipse g= new ellipse(20,40,5,10);
//		obst[4] = g;
//		Circle 	d  =  new Circle(56,74,15);
//		obst[0] = d ;
		
//		Segment d1 = new Segment(40,70,30,60);
//		obst[0] = d1;
//		Segment d2 = new Segment(30,60,60,30);
//		obst[1] = d2;
//		Segment d3 = new Segment(60,30,50,80);
//		obst[2] = d3;
//		Segment d4 = new Segment(30,60,30,40);
//		obst[3] = d4;
		
		
//		Segment d2 = new Segment(10,50,35,25);
//		obst[0] = d2;
		
//		Segment d3 = new Segment(35,25,30,20);
//		obst[2] = d3;
		
		
		
//		ellipse e = new ellipse(50,50,10,5);
//		obst[0] = e;
//		double Points[][] = {{40+10,50+10,70+10,92,65},{50,70,60,40,50+10}};
//		Polygon f = new Polygon(Points);
//		obst[2] = f ;	
		
		Graph graph = new Graph(x0,y0,xlength,ylength,obst,en_des);
		
		Astar sObj=new Astar();
//		test.Astar sObj_t=new test.Astar();
//		test.Graph gr= Astar.Conver_graph(graph);
//		ArrayList<LinkedList<test.Node_cube>> array_Man = new ArrayList<LinkedList<test.Node_cube>>();
//		array_Man = sObj_t.Astar_Chebyshev();
		long startTime = System.currentTimeMillis(); 
		ArrayList<LinkedList<Node>> array = new ArrayList<LinkedList<Node>>();

//		LinkedList<Node> trace = new LinkedList<>();	
		array = sObj. Astar_2D(graph,5,8,0.1745,-2.356);
		
//		array = sObj. Astar_2D_Depth(graph,5,8,0.1745,-2.356);
//		array = sObj.Astar_2D_Cheb(graph,5,8,0.1745,-2.356);
		System.out.println(array.get(0).size());
//		for(int i=0;i < trace.size();i++)
//		{
//
//			System.out.println("x:"+trace.get(i).x+"y:"+trace.get(i).y);
//		}
		
		Draw frame = new Draw(en_des,obst,xlength,ylength,array);
    	frame.setVisible(true);
    	long endTime = System.currentTimeMillis(); 
    	System.out.println("Use of time:"+(endTime-startTime));
//		double points[][] = {{0,0,1,1,0.5,0.5,3,3},{0,3,3,2,2,1,2,0}};
//		double seg1[][] = {{-1,-1},{-7,-1}};
//		Segment seg = new Segment(seg1[0][0],seg1[1][0],seg1[0][1],seg1[1][1]);
//		Circle C = new Circle(0,0,2);
//		System.out.println(Graph.isCrossCircle(C,seg));
//		double seg2[][] = {{1,1},{-1,-0.0001}};
//		boolean isCrossSegment = Graph.isCrossSegment(seg1,seg2);
//		boolean isInPolygon = Graph.isInPolygon(a,points);
//		boolean isInSegment = Graph.isInSegment(a,points);
//		System.out.println(isCrossSegment);
//		System.out.println(isInSegment);
//		int obs[][] = new int [2][40];
//		int en_des[][] = {{10,0},{10,0}};
//		int x1 ;
//		int x2 ;
//		for (int i =0; i< 40;)
//		{
//			x1 = (int)(Math.random()*10);
//			x2 = (int)(Math.random()*10);
//			System.out.println("x1:"+x1);
//			System.out.println("x2:"+x2);
//			if(((x1==en_des[0][0])&&(x2==en_des[1][0]))||((x1==en_des[0][1])&&(x2==en_des[1][1])))
//			{
//				continue;
//			}
//			obs[0][i]  = x1;
//			obs[1][i]  = x2;
//			i++;
//		}
//		
//		int a1 = 11;
//		int b1 = 11;
//		Graph a = new Graph(a1,b1,obs,en_des);
//		LinkedList<Node> trace = new LinkedList<>();
//		Astar sObj=new Astar();
//		trace = sObj. Astar_Chebyshev(a);
//		System.out.println(trace.size());
//		int trace_location[][] = new int [2][trace.size()];
//		for(int i=0;i < trace.size();i++)
//		{
//			
//			trace_location[0][i]=trace.get(i).x;
//			trace_location[1][i]=trace.get(i).y;
//			System.out.println("x:"+trace.get(i).x+"y:"+trace.get(i).y);
//		}
//
//		Draw frame = new Draw(en_des,obs,trace_location,a1,b1);
//    	frame.setVisible(true);

//		System.out.println(a.members[1][2].equals(a.members[1][1]));
//		Node members[][]= new Node[10][10];
//		Node Nodes[] = new Node[10];
//		LinkedList<Node> list = new LinkedList<>();
//		extend(list);
//		System.out.println(list.get(0).x);
//		Node a = new Node(1,1);
//		Node b = new Node(1,2);
//		Node c = new Node(1,3);
//		Node d = new Node(1,4);
//		Node e = new Node(1,5);
//		Node f = new Node(1,6);
//		f.Father =e;
//		e.Father =d;
//		d.Father =c;
//		c.Father =b;
//		b.Father =a;
//		System.out.println(findRealGx(f));
//		Random random = new Random();
//		for(int i =0 ;i< 10;i++)
//		{
//			Nodes[i] = new Node(i,i);
//			Nodes[i].fx = (int)(Math.random()*100);
//			Nodes[i].hx = (int)(Math.random()*100);
//			System.out.println("fx: " +Nodes[i].fx+" hx:" +Nodes[i].hx);
//			list.add(Nodes[i]);
//		}
		
	}
}