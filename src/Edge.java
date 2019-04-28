import javafx.scene.shape.Line;

/**
 * Edge = Line 
 * @author Ashan
 *
 */
public class Edge {
	private double startX = 0;
	private double startY = 0;
	private double endX = 0;
	private double endY = 0;
	private boolean hasVisited;

	public Edge(double startX, double startY, double endX, double endY) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}
	
	public Line getLine() {
		return new Line(startX, startY, endX, endY);
	}
	
	public void hasVisited(boolean hasVisited) {
		this.hasVisited = hasVisited;
	}
	
	public boolean getHasVisted() {
		return hasVisited; 
	}
	
	
}
