import javafx.scene.shape.Line;

/**
 * Vertex = A point (or a line that start = end points) 
 * @author Ashan
 *
 */
public class Vertex {

	private double point; 
	private Edge[] edges; 
	
	
	Vertex(double point){
		this.point = point; 
	}
	// accept a number of edges and determine which ones intersect with this point

	public Line getPoint(){
		return new Line(point, point, point, point); 
	}
	
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
			
			if (startx == point) count++; 
			if (starty == point) count++; 
			if (endx == point) count++; 
			if (endy == point) count++; 
			
		}
		return count / 2;  
	}
}
