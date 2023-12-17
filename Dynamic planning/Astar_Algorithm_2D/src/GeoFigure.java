
public abstract class GeoFigure {

}

/**
 * Represents a rectangular shape.
 */
class Rect extends GeoFigure {
	double x;
	double y;
	double x_length;
	double y_length;

	public Rect(double x, double y, double x_length, double y_length) {
		this.x = x;
		this.y = y;
		this.x_length = x_length;
		this.y_length = y_length;
	}

	/**
	 * Converts the rectangular shape into an array of points.
	 *
	 * @param a The rectangular shape to convert.
	 * @return An array representing the rectangular shape.
	 */
	public static double[][] Conver(Rect a) {
		double[][] rect = new double[2][4];
		rect[0][0] = a.x - a.x_length / 2.0;
		rect[1][0] = a.y - a.y_length / 2.0;
		rect[0][1] = a.x - a.x_length / 2.0;
		rect[1][1] = a.y + a.y_length / 2.0;
		rect[0][2] = a.x + a.x_length / 2.0;
		rect[1][2] = a.y + a.y_length / 2.0;
		rect[0][3] = a.x + a.x_length / 2.0;
		rect[1][3] = a.y - a.y_length / 2.0;
		return rect;
	}

}

/**
 * Represents a polygon shape.
 */
class Polygon extends GeoFigure {
	double Points[][];

	/**
	 * Converts the polygon shape into an array of points.
	 *
	 * @param a The polygon shape to convert.
	 * @return An array representing the polygon shape.
	 */

	public Polygon(double Points[][]) {
		this.Points = Points;
	}

	public static double[] Polygon_x(Polygon polygon) {
		double[] x_Points = new double[polygon.Points[0].length + 1];
		for (int i = 0; i < polygon.Points[0].length; i++) {
			x_Points[i] = polygon.Points[0][i];
		}
		x_Points[polygon.Points[0].length] = polygon.Points[0][0];
		return x_Points;
	}

	public static double[] Polygon_y(Polygon polygon) {
		double[] y_Points = new double[polygon.Points[1].length + 1];
		for (int i = 0; i < polygon.Points[1].length; i++) {
			y_Points[i] = polygon.Points[1][i];
		}
		y_Points[polygon.Points[1].length] = polygon.Points[1][0];
		return y_Points;
	}

	// public Polygon(double xPoints[],double yPoints[],int points_num)
	// {
	// double Points[][]= new double[2][points_num];
	// for(int i = 0 ; i< points_num ;i++)
	// {
	// Points[0][i]
	// }
	// this.Points = Points;
	// }

	public static double[][] Conver(Polygon a) {
		double[][] result = a.Points;
		return result;
	}
}

class Circle extends GeoFigure {
	double x;
	double y;
	double r;

	public Circle(double x, double y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

}

class Segment extends GeoFigure {
	double x1;
	double y1;
	double x2;
	double y2;

	public Segment(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	public static double[][] Conver(Segment seg) {
		double[][] result = new double[2][2];
		result[0][0] = seg.x1;
		result[1][0] = seg.y1;
		result[0][1] = seg.x2;
		result[1][1] = seg.y2;
		return result;
	}
}

class ellipse extends GeoFigure {
	double x;
	double y;
	double a;
	double b;

	public ellipse(double x, double y, double a, double b) {
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
	}

	public static Rect Conver(ellipse elli) {
		Rect result = new Rect(elli.x, elli.y, 2 * elli.a, 2 * elli.b);
		return result;
	}
}
