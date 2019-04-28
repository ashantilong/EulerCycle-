import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Vertex = A point (or a line that start = end points) 
 * @author Ashan
 *
 */
public class Vertex {

	private double pointX; 
	private double pointY; 
	private Edge[] edges; 
	private Line pointDraw; 
	
	
	Vertex(double pointX, double pointY ){
		this.pointX = pointX;
		this.pointY = pointY;
	}
	// accept a number of edges and determine which ones intersect with this point

	public Line getPoint(){
		this.pointDraw = new Line(pointX, pointY, pointX, pointY); 
		pointDraw.setStroke(Color.RED);
		pointDraw.setStrokeWidth(4);
		return pointDraw; 
	}
	
	/**
	 * Every vertex has at least 2 edges leaving it. 
	 * @param edges
	 */
	public void setEdges(Edge... edges ) {
		this.edges = edges; 
	}
	
	
	
	public int getNumberOfDegrees() {
		int count = 0; 
		for (int i = 0; i < edges.length; i++) {
			double startx = edges[i].getLine().getStartX(); 
			double endx = edges[i].getLine().getEndX(); 
			double starty = edges[i].getLine().getStartY(); 
			double endy = edges[i].getLine().getEndY(); 
			
			if (startx == pointX) count++; 
			if (starty == pointY) count++; 
			if (endx == pointX) count++; 
			if (endy == pointY) count++; 
			
		}
		return count / 4;  
	}
	
}
