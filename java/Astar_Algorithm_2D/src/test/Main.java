package test;
import java.util.ArrayList;
import java.util.LinkedList;

//import tests.DrawLine;

public class Main extends Astar
{

	public static void main(String []args)
	{
		int obs[][] = new int [2][200];
		int en_des[][] = {{4,26},{4,26}};
		int x1 ;
		int x2 ;
		for (int i =0; i< 200;)
		{
			x1 = (int)(Math.random()*30);
			x2 = (int)(Math.random()*30);
//			System.out.println("x1:"+x1);
//			System.out.println("x2:"+x2);
			if(((x1==en_des[0][0])&&(x2==en_des[1][0]))||((x1==en_des[0][1])&&(x2==en_des[1][1])))
			{
				continue;
			}
			obs[0][i]  = x1;
			obs[1][i]  = x2;
			i++;
		}
		
		int a1 = 30;
		int b1 = 30;
		Graph a = new Graph(a1,b1,obs,en_des);
//		LinkedList<Node_cube> trace = new LinkedList<>();
		ArrayList<LinkedList<Node_cube>> array = new ArrayList<LinkedList<Node_cube>>();
		Astar sObj=new Astar();
		array = sObj. Astar_Chebyshev(a);
		System.out.println(array.get(0).size());
		int trace_location[][] = new int [2][array.get(0).size()];
		for(int i=0;i < array.get(0).size();i++)
		{
			
			trace_location[0][i]=array.get(0).get(i).x;
			trace_location[1][i]=array.get(0).get(i).y;
			System.out.println("x:"+array.get(0).get(i).x+"y:"+array.get(0).get(i).y);
		}

//		Draw frame = new Draw(en_des,obs,trace_location,a1,b1,array);
//    	frame.setVisible(true);

//		System.out.println(a.members[1][2].equals(a.members[1][1]));
//		Node_cube members[][]= new Node_cube[10][10];
//		Node_cube Node_cubes[] = new Node_cube[10];
//		LinkedList<Node_cube> list = new LinkedList<>();
//		extend(list);
//		System.out.println(list.get(0).x);
//		Node_cube a = new Node_cube(1,1);
//		Node_cube b = new Node_cube(1,2);
//		Node_cube c = new Node_cube(1,3);
//		Node_cube d = new Node_cube(1,4);
//		Node_cube e = new Node_cube(1,5);
//		Node_cube f = new Node_cube(1,6);
//		f.Father =e;
//		e.Father =d;
//		d.Father =c;
//		c.Father =b;
//		b.Father =a;
//		System.out.println(findRealGx(f));
//		Random random = new Random();
//		for(int i =0 ;i< 10;i++)
//		{
//			Node_cubes[i] = new Node_cube(i,i);
//			Node_cubes[i].fx = (int)(Math.random()*100);
//			Node_cubes[i].hx = (int)(Math.random()*100);
//			System.out.println("fx: " +Node_cubes[i].fx+" hx:" +Node_cubes[i].hx);
//			list.add(Node_cubes[i]);
//		}
		
	}
}
