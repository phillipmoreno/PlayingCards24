package Control;

import javafx.scene.image.Image;

public class Card {
	// Variables for Card Object
	private String number, type;
	private Image image;
	private int value;

	public Card() {
	}

	// Constructor for Card Object
	public Card(String n, String t, int v) {
		this.number = n;
		this.type = t;
		this.value = v;
		image = new Image("/CardPictures/" + this.number + "_of_" + this.type + ".png");
	}

	// Getters for Card Object
	public String getNumber() {
		return this.number;
	}

	public String getType() {
		return this.type;
	}

	public Image getImage() {
		return this.image;
	}

	public int getValue() {
		return this.value;
	}

	// Setters for Card object
	public void setNumber(String n) {
		this.number = n;
	}

	public void setType(String t) {
		this.type = t;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setValue(int value) {
		this.value = value;
	}

	// ToString for Card Object
	public String toString() {
		return this.number + "_of_" + this.type;
	}
}
