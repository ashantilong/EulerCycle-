import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
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
	
    
    public static void main(String[] args) {
    	launch(args); 
    }
    
    
	@Override
	public void start(Stage stage) throws Exception {
		Line[] lines = new Line[NUMBER_OF_LINES]; 
		// 4 lines 
		for (int i= 0; i < NUMBER_OF_LINES; i++) {
			Line line1 = new Line();
			switch(i + 1) {
			case 1: // line 1 (TOP LEFT TO TOP RIGHT)
				line1.setStartX(START_X);
				line1.setStartY(START_Y);
				line1.setEndX(START_X + WIDTH);
				line1.setEndY(START_Y);
				lines[i] = line1; 
				break; 
			case 2: // (Top RIGHT TO BOTTOM RIGHT)
				line1.setStartX(START_X + WIDTH);
				line1.setStartY(START_Y);
				line1.setEndX(START_X + WIDTH);
				line1.setEndY(START_Y + HEIGHT);
				lines[i] = line1; 
				break; 
			case 3: // (BOTTOM RIGHT to BOTTOM LEFT)
				line1.setStartX(START_X + WIDTH);
				line1.setStartY(START_Y + HEIGHT);
				line1.setEndX(START_X);
				line1.setEndY(START_Y + HEIGHT);
				lines[i] = line1; 
				break; 
			case 4:  // (BOTTOM LEFT to TOP LEFT)
				line1.setStartX(START_X);
				line1.setStartY(START_Y + HEIGHT);
				line1.setEndX(START_X);
				line1.setEndY(START_Y);
				lines[i] = line1; 
				break; 
			default:
				throw new Exception("Incorrect number of lines given"); 
			}
			
		}
		root.getChildren().addAll(lines);			
		Scene scene = new Scene(root, 600, 600); 
		stage.setTitle("Euler Graph");
		stage.setScene(scene);
		stage.show();
		
	}

}
