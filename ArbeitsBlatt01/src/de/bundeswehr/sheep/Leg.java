package de.bundeswehr.sheep;
import de.bundeswehr.graphics.Colour;
import de.bundeswehr.graphics.Ellipse;

public class Leg {

	private int xPos;
	private int yPos;
	private Ellipse leg;
	
	Leg(int x, int y){
		xPos = x;
		yPos = y;
		leg = new Ellipse(20, 80, x, y, Colour.BLACK);
	}
	
	void draw(){
		leg.draw();
	}
	
}
