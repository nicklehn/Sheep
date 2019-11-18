package de.bundeswehr.sheep;
import de.bundeswehr.graphics.Colour;
import de.bundeswehr.graphics.Ellipse;

public class Ear {

	private int xPos;
	private int yPos;
	private Ellipse ear;
	private Colour colour;
	
	Ear(int x, int y, Colour initialColour) {
		
		xPos = x;
		xPos = y;
		colour = initialColour;
		ear = new Ellipse(50, 20, x, y, initialColour);
		
	}
	
	void wagEar() {
		this.ear.setHorizontalLength(20);
		this.ear.setVerticalLength(50);
		this.ear.move(-5, -40);
		this.ear.draw();
	}
	
	void unwag() {
		this.ear.erase();
		this.ear.setHorizontalLength(50);
		this.ear.setVerticalLength(20);
		this.ear.move(+5, +40);
		this.ear.draw();
	}
	
	void eat() {
		this.ear.move(0, 90);
		this.ear.draw();
	}
	
	void uneat() {
		this.ear.erase();
		this.ear.move(0, -90);
		this.ear.setColour(Colour.GREEN);
		this.ear.draw();
	}
	
	void digest() {
		this.ear.erase();
		this.ear.setColour(Colour.RED);
		this.ear.draw();
	}
	
	void draw() {
		ear.draw();
	}
	
}
