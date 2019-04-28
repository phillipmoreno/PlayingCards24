import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class PlayingCards24Controller {
	
	ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    
	@FXML
	private ImageView cardInWindow1;

	@FXML
	private ImageView cardInWindow2;

	@FXML
	private ImageView cardInWindow3;

	@FXML
	private ImageView cardInWindow4;

	@FXML
	private TextField solutionTextField;

	@FXML
	private TextField expressionTextField;

	@FXML
	private Button refreshButton;

	@FXML
	private Button verifyButton;

	@FXML
	void aboutTheApplication(ActionEvent event) {
		JOptionPane.showMessageDialog(null,
				"Card Game 24 \n\nVersion: 2019-4 (1.1.1)\nAuthor(s): Phillip Moreno\nIvan Williams\nMoumen Juma\nMurad Gazi\n\nDescription: This game randomly generates four "
						+ "\ndifferent cards that can be used in a math \nequation based on their value and total to 24.\n\n",
				"About The Application", 1);
	}

	@FXML
	void closeWindow(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void findSolution(ActionEvent event) {

	}

	@FXML
	void refresh(ActionEvent event) {
		solutionTextField.setText("");
		expressionTextField.setText("");

	}

	@FXML
	void verify(ActionEvent event) {

	}

}
