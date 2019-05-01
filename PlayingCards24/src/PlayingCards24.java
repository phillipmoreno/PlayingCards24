import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * BCS 345 Semester Project: Card Game 24
 * 
 * Professor: Moaath Alrajab
 * 
 * @author Phillip Moreno, Ivan Williams, Moumen Juma, Murad Gazi
 * 
 * @version (May 1, 2019)
 * 
 *          Description: This program will ask the user to enter input to use as
 *          a mathematical equation for four randomly generated cards that
 *          equals to 24.
 * 
 */
public class PlayingCards24 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Parent object is created
		Parent root = FXMLLoader.load(getClass().getResource("PlayingCards24GUI.fxml"));
		// Scene object is created and parent object is used as a parameter
		Scene scene = new Scene(root);
		// Stage is set
		primaryStage.setScene(scene);
		// The Stage title is set
		primaryStage.setTitle("Playing Cards 24");
		// The Stage icon is set to a .png image
		primaryStage.getIcons().add(new Image("24-logo.png"));
		// The stage is displayed
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
}
