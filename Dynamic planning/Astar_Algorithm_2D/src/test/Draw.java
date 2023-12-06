package test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;

import colormap.ColorMap;
	class Draw extends JFrame 
	{  
		private static final long serialVersionUID = 1L;
//		private JPanel panel = new JPanel();
		
		int x_length;
		int y_length;
	    private int  en_des[][];
	    private int obstacle[][];
	    private int  trace[][];
	    ArrayList<LinkedList<Node_cube>> array;
		Point start;   
	    Point end;   
	    Container p;   
	    Point grid;
	    public Draw(int en_des[][],int obstacle[][],int trace[][],int x_length,int y_length,ArrayList<LinkedList<Node_cube>> array) //在两点之间画一条线
		    {   
//	    		int stepsize = 660/Math.max(x_length, y_length);
	    		
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
	    	int stepsize = 660/Math.max(x_length, y_length);
	        final Graphics g = gg;   
	        g.setColor(Color.red);
	        Graphics2D g2 = (Graphics2D)g;
	        Runnable run = new Runnable() 
	        {   
	            public void run() 
	            {   
	            	int x0 = 80;
	            	int y0 = 80;
	            	int x1 = 80+x_length*stepsize;
	            	int y1 = 80+y_length*stepsize;
	            	g2.setColor(Color.BLACK);
	            	g2.setStroke(new BasicStroke(4.0f));
	            	g2.drawLine(x0, y0, x0, y1);  
	            	g2.drawLine(x0, y0, x1, y0);
	            	g2.drawLine(x1, y0, x1, y1);  
	            	g2.drawLine(x0, y1, x1, y1);
	            	for(int i = 0 ; i<x_length;i++)
	            	{
	            		for(int j = 0; j<y_length;j++)
	            		{
	            			g2.setColor(Color.BLACK);
	    	            	g2.setStroke(new BasicStroke(0.1f));
	            			g2.drawRect(80+i*stepsize,80+j*stepsize,stepsize,stepsize);
	            		}
	            	}
	            	
	            }   
	        };   
	        new Thread(run).start();   
	    }
		    public void paint(Graphics g)
		    {
		    	int stepsize = 660/Math.max(x_length, y_length);
		    	Toolkit tool = this.getToolkit();
		        Image image = tool.getImage("C:\\Users\\璐君\\Desktop\\大四下学期资料\\建模与仿真\\error.png");
		        Image image1 = tool.getImage("C:\\Users\\璐君\\Desktop\\大四下学期资料\\建模与仿真\\green_arrow_up.png");
		        Image image2 = tool.getImage("C:\\Users\\璐君\\Desktop\\大四下学期资料\\建模与仿真\\green_arrow_right_up.png");
		        Image image3 = tool.getImage("C:\\Users\\璐君\\Desktop\\大四下学期资料\\建模与仿真\\green_arrow_left.png");
		        Image image4 = tool.getImage("C:\\Users\\璐君\\Desktop\\大四下学期资料\\建模与仿真\\green_arrow_right.png");
		        Image image5 = tool.getImage("C:\\Users\\璐君\\Desktop\\大四下学期资料\\建模与仿真\\green_arrow_left_down.png");
		        Image image6 = tool.getImage("C:\\Users\\璐君\\Desktop\\大四下学期资料\\建模与仿真\\green_arrow_right_up.png");
		        Image image7 = tool.getImage("C:\\Users\\璐君\\Desktop\\大四下学期资料\\建模与仿真\\green_arrow_down.png");
		        Image image8 = tool.getImage("C:\\Users\\璐君\\Desktop\\大四下学期资料\\建模与仿真\\green_arrow_right_down.png");
		        Image image9 = tool.getImage("C:\\Users\\璐君\\Desktop\\大四下学期资料\\建模与仿真\\start.png");
		        Image image10 = tool.getImage("C:\\Users\\璐君\\Desktop\\大四下学期资料\\建模与仿真\\end.png");
					
		      

		        for(int i=0;i < this.obstacle[0].length;i++)
		    	{
		    		g.setColor(Color.RED);
		    		g.fillRect(80+stepsize*obstacle[0][i], 80+stepsize*(y_length-1-obstacle[1][i]), stepsize,stepsize);
		    	}
		        
		        ColorMap cmap = new ColorMap(0,array.get(2).size());
		        cmap.sea(256);
//		        ArrayList<LinkedList<Node_cube>> array;
				for(int i=0;i < array.get(1).size();i++)
		    	{
//		    		try
//		    		{
//						g.setColor(new Color(cmap.getRGB(i)));
//					}
//		    		catch (Exception e)
//		    		{
//						e.printStackTrace();
//					}
					g.setColor(Color.green);
		    		g.fillRect(80+stepsize*array.get(1).get(i).x, 80+stepsize*(y_length-1-array.get(1).get(i).y), stepsize,stepsize);
		    	}
				
				for(int i=0;i < array.get(2).size();i++)
		    	{
					try
		    		{
						g.setColor(new Color(cmap.getRGB(array.get(2).size()-0.5*i)));
					}
		    		catch (Exception e)
		    		{
						e.printStackTrace();
					}
		    		g.fillRect(80+stepsize*array.get(2).get(i).x, 80+stepsize*(y_length-1-array.get(2).get(i).y), stepsize,stepsize);
		    	}
				
		       
		    	
		        if((trace[0][0]-en_des[0][0]==1)&&(trace[1][0]-en_des[1][0]==1))
				{
		        	g.drawImage(image2, 80+stepsize*trace[0][0]+stepsize/4, 80+stepsize*(y_length-1-trace[1][0])+stepsize/4, stepsize/2,stepsize/2, this);
				}
		        else if((trace[0][0]-en_des[0][0]==1)&&(trace[1][0]-en_des[1][0]==-1))
		        {
		        	g.drawImage(image8, 80+stepsize*trace[0][0]+stepsize/4, 80+stepsize*(y_length-1-trace[1][0])+stepsize/4, stepsize/2,stepsize/2, this);
		        }
		        else if((trace[0][0]-en_des[0][0]==1)&&(trace[1][0]-en_des[1][0]==0))
		        {
		        	g.drawImage(image4, 80+stepsize*trace[0][0]+stepsize/4, 80+stepsize*(y_length-1-trace[1][0])+stepsize/4, stepsize/2,stepsize/2, this);
		        }
		        else if((trace[0][0]-en_des[0][0]==0)&&(trace[1][0]-en_des[1][0]==1))
		        {
		        	g.drawImage(image1, 80+stepsize*trace[0][0]+stepsize/4, 80+stepsize*(y_length-1-trace[1][0])+stepsize/4, stepsize/2,stepsize/2, this);
		        }
		        else if((trace[0][0]-en_des[0][0]==0)&&(trace[1][0]-en_des[1][0]==-1))
		        {
		        	g.drawImage(image7, 80+stepsize*trace[0][0]+stepsize/4, 80+stepsize*(y_length-1-trace[1][0])+stepsize/4, stepsize/2,stepsize/2, this);
		        }
		        else if((trace[0][0]-en_des[0][0]==-1)&&(trace[1][0]-en_des[1][0]==1))
		        {
		        	g.drawImage(image6, 80+stepsize*trace[0][0]+stepsize/4, 80+stepsize*(y_length-1-trace[1][0])+stepsize/4, stepsize/2,stepsize/2, this);
		        }
		        else if((trace[0][0]-en_des[0][0]==-1)&&(trace[1][0]-en_des[1][0]==0))
		        {
		        	g.drawImage(image3, 80+stepsize*trace[0][0]+stepsize/4, 80+stepsize*(y_length-1-trace[1][0])+stepsize/4, stepsize/2,stepsize/2, this);
		        }
		        else if((trace[0][0]-en_des[0][0]==-1)&&(trace[1][0]-en_des[1][0]==-1))
		        {
		        	g.drawImage(image5, 80+stepsize*trace[0][0]+stepsize/4, 80+stepsize*(y_length-1-trace[1][0])+stepsize/4, stepsize/2,stepsize/2, this);
		        }
		        else
		        {
		        	g.drawImage(image, 80+stepsize*trace[0][0]+stepsize/4, 80+stepsize*(y_length-1-trace[1][0])+stepsize/4, stepsize/2,stepsize/2, this);
		        }
		        
		        
	    	for(int i=1;i < this.trace[0].length;i++)
	    	{
	    		try 
	    		{
//	    			System.out.println(i);
	    		if((trace[0][i]-trace[0][i-1]==1)&&(trace[1][i]-trace[1][i-1]==1))
	    		{
	    			g.drawImage(image2, 80+stepsize*trace[0][i]+stepsize/4, 80+stepsize*(y_length-1-trace[1][i])+stepsize/4, stepsize/2,stepsize/2, this);
	    		}
	    		else if((trace[0][i]-trace[0][i-1])==1&&(trace[1][i]-trace[1][i-1])==-1)
	    		{
	    			g.drawImage(image8, 80+stepsize*trace[0][i]+stepsize/4, 80+stepsize*(y_length-1-trace[1][i])+stepsize/4, stepsize/2,stepsize/2, this);
	    		}
	    		else if((trace[0][i]-trace[0][i-1])==1&&(trace[1][i]-trace[1][i-1])==0)
	    		{
	    			g.drawImage(image4, 80+stepsize*trace[0][i]+stepsize/4, 80+stepsize*(y_length-1-trace[1][i])+stepsize/4, stepsize/2,stepsize/2, this);
	    		}
	    		else if((trace[0][i]-trace[0][i-1])==0&&(trace[1][i]-trace[1][i-1])==1)
	    		{
	    			g.drawImage(image1, 80+stepsize*trace[0][i]+stepsize/4, 80+stepsize*(y_length-1-trace[1][i])+stepsize/4, stepsize/2,stepsize/2, this);
	    		}
	    		else if((trace[0][i]-trace[0][i-1])==0&&(trace[1][i]-trace[1][i-1])==-1)
	    		{
	    			g.drawImage(image7, 80+stepsize*trace[0][i]+stepsize/4, 80+stepsize*(y_length-1-trace[1][i])+stepsize/4, stepsize/2,stepsize/2, this);
	    		}
	    		else if((trace[0][i]-trace[0][i-1])==-1&&(trace[1][i]-trace[1][i-1])==1)
	    		{
	    			g.drawImage(image6, 80+stepsize*trace[0][i]+stepsize/4, 80+stepsize*(y_length-1-trace[1][i])+stepsize/4, stepsize/2,stepsize/2, this);
	    		}
	    		else if((trace[0][i]-trace[0][i-1])==-1&&(trace[1][i]-trace[1][i-1])==0)
	    		{
	    			g.drawImage(image3, 80+stepsize*trace[0][i]+stepsize/4, 80+stepsize*(y_length-1-trace[1][i])+stepsize/4, stepsize/2,stepsize/2, this);
	    		}
	    		else if((trace[0][i]-trace[0][i-1])==-1&&(trace[1][i]-trace[1][i-1])==-1)
	    		{
	    			g.drawImage(image5, 80+stepsize*trace[0][i]+stepsize/4, 80+stepsize*(y_length-1-trace[1][i])+stepsize/4, stepsize/2,stepsize/2, this);
	    		}
	    		else
	    		{
	    			g.drawImage(image, 80+stepsize*trace[0][i]+stepsize/4, 80+stepsize*(y_length-1-trace[1][i])+stepsize/4, stepsize/2,stepsize/2, this);
	    		}
	    		Thread.sleep(1);
				} catch (InterruptedException e) 
	    		{
					e.printStackTrace();
				}
	    	}
	    	 
	    	try {
	    		 g.drawImage(image9, 80+stepsize*en_des[0][0], 80+stepsize*(y_length-1-en_des[1][0]), stepsize,stepsize, this);
			     g.drawImage(image10, 80+stepsize*en_des[0][1], 80+stepsize*(y_length-1-en_des[1][1]), stepsize,stepsize, this);
				Thread.sleep(20);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
	    }

	}
