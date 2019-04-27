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
	
	public int getNumberOfDegrees() {
		return edges.length;  
	}
}
