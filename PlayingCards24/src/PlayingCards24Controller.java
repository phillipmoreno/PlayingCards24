import java.util.Formatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;

import Control.Card;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class PlayingCards24Controller {

	// JavaScript Engine added to handle math equations
	ScriptEngineManager mgr = new ScriptEngineManager();
	ScriptEngine engine = mgr.getEngineByName("JavaScript");

	// Arrays created to hold the value and suits of the card
	static private String[] cardNumber = { "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen",
			"king" }, cardType = { "clubs", "diamonds", "hearts", "spades" };

	Card[] cards = new Card[] { new Card("3", "hearts", 3), new Card("king", "clubs", 13), new Card("4", "diamonds", 4),
			new Card("2", "clubs", 2) };

	long time = System.nanoTime();

	boolean isCorrect;

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
	// Closes Application
	void closeWindow(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	// Function generates a solution based on the value of the four randomly
	// generated cards
	void findSolution(ActionEvent event) {
		try {
			time = System.nanoTime() - time;
			Formatter f = new Formatter("log.txt");
			f.format("%s", "Finding solution");
			f.format("%s %s", Long.toString(TimeUnit.SECONDS.convert(time, TimeUnit.NANOSECONDS)),
					" seconds used to obtain solution");
			time = System.nanoTime();
			
			int card1 = cards[0].getValue();
			int card2 = cards[1].getValue();
			int card3 = cards[2].getValue();
			int card4 = cards[3].getValue();
			
			String c1 = Integer.toString(card1);
			String c2 = Integer.toString(card2);
			String c3 = Integer.toString(card3);
			String c4 = Integer.toString(card4);
			
			if (isCorrect == true) {
				// Returns solution if the verify function confirms you are correct
				solutionTextField.setText(expressionTextField.getText());
				f.format("%s", "Solution found");
			}
			else if (isCorrect == false) {
				// Returns "No Solution" if verify function confirms there is an incorrect input
				// or the total does not equal to 24
				solutionTextField.setText("No Solution for: [" + c1 + ", " + c2 + ", " + c3 + ", " + c4 + "]");
				f.format("%s", "No solution found");
			}
			
			
			
			f.close();
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

	@FXML
	void refresh(ActionEvent event) {
		try {
			time = System.nanoTime() - time;
			Formatter f = new Formatter("log.txt");
			f.format("%s", "Refreshing cards");
			f.format("%s %s", Long.toString(TimeUnit.SECONDS.convert(time, TimeUnit.NANOSECONDS)), " seconds used");
			f.close();
			time = System.nanoTime();

			solutionTextField.setText("");
			expressionTextField.setText("");

			// Random Generator created
			Random r = new Random();

			for (int i = 0; i < 4; i++) {
				int n1 = r.nextInt(13), n2 = r.nextInt(4);
				String number = cardNumber[n1], type = cardType[n2];
				boolean abundant = false;
				do {
					abundant = false;
					for (Card c : cards) {
						if (number.equals(c.getNumber()) && type.equals(c.getType())) {
							abundant = true;
							n1 = r.nextInt(13);
							n2 = r.nextInt(4);
							number = cardNumber[n1];
							type = cardType[n2];
						}
					}
				} while (abundant == true);
				cards[i] = new Card(number, type, n1 + 1);
			}
			// Images are set in the GUI
			cardInWindow1.setImage(cards[0].getImage());
			cardInWindow2.setImage(cards[1].getImage());
			cardInWindow3.setImage(cards[2].getImage());
			cardInWindow4.setImage(cards[3].getImage());
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

	@FXML
	// Function used to confirm whether the math equation entered equals to 24 based
	// on the value of the cards
	void verify(ActionEvent event) throws ScriptException {
		try {
			time = System.nanoTime() - time;
			Formatter f = new Formatter("log.txt");
			f.format("%s", "Verifying solution");
			f.format("%s %s", Long.toString(TimeUnit.SECONDS.convert(time, TimeUnit.NANOSECONDS)),
					" seconds used to solve");
			time = System.nanoTime();

			int[] n = new int[13];
			for (int i = 0; i < 4; i++) {
				n[cards[i].getValue() - 1]++;
			}
			String expressionInput = expressionTextField.getText();
			if (expressionInput.contains(Integer.toString(cards[0].getValue()))
					&& expressionInput.contains(Integer.toString(cards[1].getValue()))
					&& expressionInput.contains(Integer.toString(cards[2].getValue()))
					&& expressionInput.contains(Integer.toString(cards[3].getValue()))) {

				if (count(expressionInput, Integer.toString(cards[0].getValue())) == n[cards[0].getValue() - 1]
						&& count(expressionInput, Integer.toString(cards[1].getValue())) == n[cards[1].getValue() - 1]
						&& count(expressionInput, Integer.toString(cards[2].getValue())) == n[cards[2].getValue() - 1]
						&& count(expressionInput, Integer.toString(cards[3].getValue())) == n[cards[3].getValue() - 1]
						&& count(expressionInput, "") == 4) {
					if (engine.eval(expressionInput).equals(24)) {
						isCorrect = true;
						System.out.println(engine.eval(expressionInput));
						JOptionPane.showMessageDialog(null, "Success! The total is 24.", "Verify Math Equation", 1);
						f.format("%s", "Solution is correct");
					} else {
						isCorrect = false;
						System.out.println(engine.eval(expressionInput));
						JOptionPane.showMessageDialog(null, "Oops! The total is not 24, Please try again.",
								"Verify Math Equation", 1);
						f.format("%s", "Solution is incorrect");
					}
				}
				else {
					isCorrect = false;
					JOptionPane.showMessageDialog(null, "Incorrect input. Please try again.", "Verify Math Equation", 1);
					f.format("%s", "Incorrect input");
				}
			} else {
				isCorrect = false;
				JOptionPane.showMessageDialog(null, "Incorrect input. Please try again.", "Verify Math Equation", 1);
				f.format("%s", "Incorrect input");
			}
			f.close();
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

	public int count(String str, String n) {
		int count = 0;
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(str);
		while (m.find()) {
			if(n.equals("")) {
				count++;
			}
			else {
				if (m.group().equals(n)) {
					count++;
				}
			}
		}
		return count;
	}
}
