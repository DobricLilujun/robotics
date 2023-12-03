
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
//import java.awt.Polygon; 

import colormap.ColorMap;

	class Draw extends JFrame 
	{  
		private static final long serialVersionUID = 1L;
		
		double x_length;
		double y_length;
	    private double  en_des[][];
	    private Object obstacle[];
	    private LinkedList<Node> trace;
	    ArrayList<LinkedList<Node>> array;
		Point start;   
	    Point end;   
	    Container p;   
	    Point grid;
	    public Draw(double en_des[][],Object[]obstacle ,double  x_length,double  y_length,ArrayList<LinkedList<Node>> array) //在两点之间画一条线
	    {   
	    	setSize(800,800);
	    	setLocation(250,20);
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	this.x_length = x_length;
	    	this.y_length = y_length;
	    	this.en_des = en_des;
	    	this.obstacle = obstacle;
	    	this.trace = trace;
	    	this.array = array;
	        setVisible(true);     
	        paintComponents(this.getGraphics());   
	        setResizable(false);   
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    }
	    
	    public void paintComponents(Graphics gg) 
	    {   
	        final Graphics g = gg;   
	        g.setColor(Color.red);
	        Graphics2D g2 = (Graphics2D)g;
	        int stepsize = 6;
	        Runnable run = new Runnable()
	        {   
	            public void run() 
	            {   
	            	double x0 = 80;
	            	double y0 = 80;
	            	double x1 = 80+x_length*6;
	            	double  y1 = 80+y_length*6;
//	            	Line2D line1 = new Line2D.Double(x0, y0, x0, y1);
//	            	
//	            	Line2D line2 = new Line2D.Double(x0, y0, x1, y0);
//	            	Line2D line3 = new Line2D.Double(x1, y0, x1, y1);
//	            	Line2D line4 = new Line2D.Double(x0, y1, x1, y1);
	            	Line2D line_path = new Line2D.Double(0,0,0,0);
	            	Ellipse2D o_PATH = new Ellipse2D.Double(0,0,0,0);
	            	g2.setColor(Color.BLACK);
	            	g2.setStroke(new BasicStroke(4.0f));
	            	try
		    		{
	            		g2.drawLine((int)x0, (int)y0, (int)x0, (int)y1);
					}
		    		catch (Exception e)
		    		{
						e.printStackTrace();
					}
	            	
	            	try
		    		{
	            		g2.drawLine((int)x0, (int)y0, (int)x1, (int)y0);
					}
		    		catch (Exception e)
		    		{
						e.printStackTrace();
					}
	            	
	            	try
		    		{
	            		g2.drawLine((int)x1, (int)y0,(int) x1, (int)y1);  
					}
		    		catch (Exception e)
		    		{
						e.printStackTrace();
					}
	            	try
		    		{
	            		g2.drawLine((int)x0, (int)y1, (int)x1, (int)y1);
					}
		    		catch (Exception e)
		    		{
						e.printStackTrace();
					}
	            	g2.drawLine((int)x0, (int)y0, (int)x0, (int)y1);
	            	g2.drawLine((int)x0, (int)y0, (int)x1, (int)y0);
	            	g2.drawLine((int)x1, (int)y0,(int) x1, (int)y1);  
	            	g2.drawLine((int)x0, (int)y1, (int)x1, (int)y1);
	            	
	            	g2.setColor(Color.YELLOW);
	            	o_PATH.setFrame(80+(en_des[0][0]-3)*6,680-(en_des[1][0]+3)*6,2*3*6,2*3*6);
	            	g2.fill(o_PATH);
	            	o_PATH.setFrame(80+(en_des[0][1]-3)*6,680-(en_des[1][1]+3)*6,2*3*6,2*3*6);
	            	g2.fill(o_PATH);
//	            	g2.draw(line1);
//	            	g2.draw(line2);
//	            	g2.draw(line3);
//	            	g2.draw(line4);
//	            
//		        	for(int i = 0;i< trace.size()-1;i++)
//		        	{
//		        			g2.setStroke(new BasicStroke(2.0f));
//		        			g2.setColor(Color.RED);
//	        				line_path.setLine(80+array.get(0).get(i).x*6,680-array.get(0).get(i).y*6,80+array.get(0).get(i+1).x*6,680-array.get(0).get(i+1).y*6);
//		        			g2.draw(line_path);
//		        	}
		        	
//		        	line_path.setLine(array.get(0).get(array.get(0).size()-1).x*6,680+array.get(0).get(array.get(0).size()-1).y*6,array.get(0).get(0).x*6,680+array.get(0).get(0).y*6);
//		        	g2.draw(line_path);
		        	
		        	ColorMap cmap = new ColorMap(0,array.get(2).size());
			        cmap.sea(256);
			        
			        for(int i=0;i < array.get(0).size()-1;i++)
			    	{
						g2.setStroke(new BasicStroke(2.0f));
						g2.setColor(Color.RED);
//						o_PATH.setFrame(80+(array.get(0).get(i).x-0.5)*6,680-(array.get(0).get(i).y+0.5)*6,2*0.5*6,2*0.5*6);
						line_path.setLine(80+array.get(0).get(i).x*6,680-array.get(0).get(i).y*6,80+array.get(0).get(i+1).x*6,680-array.get(0).get(i+1).y*6);
//			    		g2.fill(o_PATH);
						g2.draw(line_path);
			    	}
			        line_path.setLine(80+array.get(0).get(array.get(0).size()-1).x*6,680-array.get(0).get(array.get(0).size()-1).y*6,80+en_des[0][1]*6,680-en_des[1][1]*6);
//		    		g2.fill(o_PATH);
					g2.draw(line_path);
					
//					System.out.println("array.get(3).size"+array.get(3).size());
//			        for(int i=0;i < array.get(3).size()-1;i++)
//			    	{
////			        	System.out.println("------------------"+array.get(3).size());
//						g2.setStroke(new BasicStroke(2.0f));
//						g2.setColor(Color.RED);
////						o_PATH.setFrame(80+(array.get(0).get(i).x-0.5)*6,680-(array.get(0).get(i).y+0.5)*6,2*0.5*6,2*0.5*6);
//						line_path.setLine(80+array.get(3).get(i).x*6,680-array.get(3).get(i).y*6,80+array.get(3).get(i+1).x*6,680-array.get(3).get(i+1).y*6);
////			    		g2.fill(o_PATH);
//						g2.draw(line_path);
//			    	}
					
			        
					for(int i=0;i < array.get(1).size()-1;i++)
			    	{
						g2.setStroke(new BasicStroke(2.0f));
						g2.setColor(Color.GREEN);
						o_PATH.setFrame(80+(array.get(1).get(i).x-0.5)*6,680-(array.get(1).get(i).y+0.5)*6,2*0.5*6,2*0.5*6);
						g2.fill(o_PATH);
			    	}
					for(int i=0;i < array.get(2).size()-1;i++)
			    	{
						try
			    		{
							g.setColor(new Color(cmap.getRGB(array.get(2).size()-0.5*i)));
						}
			    		catch (Exception e)
			    		{
							e.printStackTrace();
						}
						o_PATH.setFrame(80+(array.get(2).get(i).x-0.5)*6,680-(array.get(2).get(i).y+0.5)*6,2*0.5*6,2*0.5*6);
						g2.fill(o_PATH);
			    	
			    	}
		        	
		        	for(int i = 0 ; i<obstacle.length;i++)
		        	{
		    				if(obstacle[i].getClass().equals(Rect.class))//画矩形
		    				{
		    					Rect a = (Rect) obstacle[i];
		    					Rectangle2D rect = new Rectangle2D.Double(a.x-a.x_length/2.0,a.y-a.y_length/2.0,x_length,y_length);
		    					g2.setStroke(new BasicStroke(2.0f));
			        			g2.setColor(Color.BLUE);
		    					g2.fill(rect);
		    				}
		    				else if(obstacle[i].getClass().equals(Polygon.class))//画多边形
		    				{
		    					g2.setStroke(new BasicStroke(4.0f));
			        			g2.setColor(Color.BLUE);
		    					Polygon a = (Polygon)obstacle[i];
		    					for(int j = 0; j<a.Points[0].length-1;j++)
		    					{
		    						line_path.setLine(80+a.Points[0][j]*6,680-a.Points[1][j]*6,80+a.Points[0][j+1]*6,680-a.Points[1][j+1]*6);
		    						g2.draw(line_path);
		    					}
		    					line_path.setLine(80+a.Points[0][a.Points[0].length-1]*6,680-a.Points[1][a.Points[0].length-1]*6,80+a.Points[0][0]*6,680-a.Points[1][0]*6);
		    					g2.draw(line_path);
		    				}
		    				else if(obstacle[i].getClass().equals(Circle.class))//画圆形
		    				{
//		    					System.out.println("i ama heer");
		    					Circle c = (Circle)obstacle[i];
//		    					System.out.println(c.x);
//		    					System.out.println(c.y);
//		    					System.out.println(c.r);
//		    					System.out.println("i ama heer");
		    					Ellipse2D o = new Ellipse2D.Double(80+(c.x-c.r)*6,680-(c.y+c.r)*6,2*c.r*6,2*c.r*6);
		    					g2.setStroke(new BasicStroke(4.0f));
		    					g2.setColor(Color.BLUE);
			        			g2.fill(o);
		    				}
		    				else if(obstacle[i].getClass().equals(Segment.class))//画线段
		    				{
		    					Segment a = (Segment)obstacle[i];
		    					g2.setStroke(new BasicStroke(4.0f));
			        			g2.setColor(Color.BLUE);
			        			line_path.setLine(80+a.x1*6,680-a.y1*6,80+a.x2*6,680-a.y2*6);
			        			g2.draw(line_path);
		    				}
		    				else if(obstacle[i].getClass().equals(ellipse.class))//画椭圆
		    				{
		    					ellipse c = (ellipse)obstacle[i];
		    					Ellipse2D o = new Ellipse2D.Double(80+(c.x-c.a)*6,680-(c.y+c.b)*6,2*c.a*6,2*c.b*6);
		    					g2.setStroke(new BasicStroke(4.0f));
		    					g2.setColor(Color.BLUE);
			        			g2.fill(o);
		    				}
		    				else
		    				{
		    					System.out.println("This obstacle is not in the obstacle system.");
		    					System.exit(0);
		    				}
		        	}
		        	
	            }
	        };
	    new Thread(run).start(); 
	    }
}

	    

	    	