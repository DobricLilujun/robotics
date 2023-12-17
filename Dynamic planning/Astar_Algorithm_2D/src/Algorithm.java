
import java.util.ArrayList;
import java.util.LinkedList;

// The core of the program is to set the color for each pixel in a loop. The color is obtained using the cmap.getRGB(height-1-y) method.

// where y is the vertical coordinate of the pixel.

// Finally, the resulting image is saved in BMP format in the "test.bmp" file in the current working directory.

public abstract class Algorithm {
	// abstract void Astar_Euclidean(Graph graph);
	// abstract LinkedList<Node> Astar_Manhattan(Graph graph);
	// abstract LinkedList<Node> Astar_Chebyshev(Graph graph);
	// abstract static double findRealGx(Node node);
	// abstract ArrayList<LinkedList<Node>> Astar_Chebyshev(Graph graph);
	abstract ArrayList<LinkedList<Node>> Astar_2D(Graph graph, int NumOfSearhPoints, double StepSize,
			double SearchAngle);
}
