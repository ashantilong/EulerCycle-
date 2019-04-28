import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.animation.StrokeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * Case1
 * Euler Circult/Euler Path: 
 * 
 * Case2
 * Euler Path:
 * 
 * Case3
 * None:
 * 
 * A Euler Circult is defined or equal to having a even set of degrees while
 * if a Euler Circult has 2 odd degress then it states it has an Euler Path 
 * However; if all vertices is of odd degrees then you have no Euler Circult or Path 
 * @author Ashan
 *
 */
public class EulerCycle extends Application{

	private static final int NUMBER_OF_LINES = 4;
	private static final double WIDTH = 400;
	private static final double HEIGHT = 400;
	private Group root = new Group(); 
	private final double START_X = 100.0; 
	private final double START_Y = 150.0; 
	private Vertex v1, v2, v3, v4; 
	Line[] lines = new Line[NUMBER_OF_LINES]; 
	Edge edge1 = null, edge2 = null, edge3 = null, edge4 = null; 
	ArrayList<Edge> edges = new ArrayList<>(); 
	ArrayList<Vertex> vertices = new ArrayList<>(); 
	boolean allEven = false; 
	int oddCount = 0; 

    public static void main(String[] args) {
    	launch(args); 
    }
    
    
	@Override
	public void start(Stage stage) throws Exception {
		
		// 4 lines 
		for (int i= 0; i < NUMBER_OF_LINES; i++) {
			Line line1 = new Line();
			switch(i + 1) {
			case 1: // line 1 (TOP LEFT TO TOP RIGHT)
				edge1 = new Edge(START_X,START_Y,START_X+WIDTH,START_Y);
				lines[i] = edge1.getLine();
				break; 
			case 2: // (Top RIGHT TO BOTTOM RIGHT)
				edge2 = new Edge(START_X + WIDTH,START_Y,START_X+WIDTH,START_Y + HEIGHT);
				lines[i] = edge2.getLine(); 
				break; 
			case 3: // (BOTTOM RIGHT to BOTTOM LEFT)
				edge3 = new Edge(START_X + WIDTH,START_Y + HEIGHT,START_X,START_Y + HEIGHT);
				lines[i] = edge3.getLine(); 
				break; 
			case 4:  // (BOTTOM LEFT to TOP LEFT)
				edge4 = new Edge(START_X,START_Y + HEIGHT,START_X,START_Y);
				lines[i] = edge4.getLine(); 
				break; 
			default:
				throw new Exception("Incorrect number of lines given"); 
			}
			
		}
		v1 = new Vertex(START_X, START_Y); 
		v1.setEdges(edge1, edge2, edge3, edge4);
		v2 = new Vertex(START_X + WIDTH,START_Y); 
		v2.setEdges(edge1, edge2, edge3, edge4);
		v3 = new Vertex(START_X + WIDTH,START_Y + HEIGHT);
		v3.setEdges(edge1, edge2, edge3, edge4); 
		v4 = new Vertex(START_X,START_Y + HEIGHT);
		v4.setEdges(edge1, edge2, edge3, edge4);
		edges.addAll(Arrays.asList(edge1, edge2, edge3, edge4)); 
		vertices.addAll(Arrays.asList(v1, v2, v3, v4)); 
				
		System.out.printf(" Vertex 1 has %d degrees \n", v1.getNumberOfDegrees());
		System.out.printf(" Vertex 2 has %d degrees \n", v2.getNumberOfDegrees());
		System.out.printf(" Vertex 3 has %d degrees \n", v3.getNumberOfDegrees());
		System.out.printf(" Vertex 4 has %d degrees \n", v4.getNumberOfDegrees());
		root.getChildren().addAll(lines);			
		root.getChildren().addAll(v1.getPoint(), v2.getPoint(),v3.getPoint(),v4.getPoint());			
		
		
		vertices.stream().forEach(v -> {
			allEven = v.getNumberOfDegrees() % 2 == 0 ? true:false;
			if (!allEven) oddCount++; 
		});
		int i = 0; 
		playNextAnimation(i, lines);
		String resultStr;
		if (oddCount == vertices.size()) {
			resultStr = ("Niether a Euler Path nor Euler Circuit");
		}
		else if (oddCount == 2) {
			resultStr = "Euler path exists"; 
		}
		else {
			resultStr = ("Euler Circult exists");
		}
	  
		Label result = new Label(resultStr); 
		root.getChildren().add(result);
		Scene scene = new Scene(root, 600, 600); 
		stage.setTitle("Euler Graph");
		stage.setScene(scene);
		stage.show();

	
	}
	
	private void playNextAnimation(int index,  Line[] lines) {
		if (index == lines.length) {
			System.out.println("Done with animations");
		}else {
			StrokeTransition strTrans = new StrokeTransition();
			strTrans.setAutoReverse(true);
			strTrans.setToValue(Color.CRIMSON);
			strTrans.setFromValue(Color.BLUE);
			strTrans.setDelay(Duration.millis(250));
			strTrans.setCycleCount(1);
			strTrans.setDuration(Duration.seconds(3));
			strTrans.setShape(lines[index]);
			strTrans.setOnFinished(e -> playNextAnimation(index + 1, lines));
			strTrans.play();
		}
		
		
	}

}
