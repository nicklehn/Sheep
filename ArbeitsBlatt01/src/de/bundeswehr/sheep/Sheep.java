package de.bundeswehr.sheep;
import de.bundeswehr.graphics.Colour;
import de.bundeswehr.graphics.Ellipse;
import de.bundeswehr.graphics.HelperClass;

public class Sheep {
	
	private int xPos;
	private int yPos;
	private Colour colour;
	private Ellipse body;
	private Ellipse tail;
	Head face;
	Leg leg1;
	Leg leg2;
	Leg leg3;
	Leg leg4;
	
	public Sheep(int x, int y, Colour initialColour) {
		
		xPos = x;
		yPos = y;
		colour = initialColour;
		body = new Ellipse(180, 120, x, y, initialColour);
		tail = new Ellipse(20, 50, x+174, y+60, initialColour);
		face = new Head(x-60, y-40, initialColour);
		leg1 = new Leg(x+30, y+90);
		leg2 = new Leg(x+5, y+80);
		leg3 = new Leg(x+150, y+90);
		leg4 = new Leg(x+125, y+80);
		
		
	}
	
	public void sniff() {
		HelperClass.wait(1000);
		face.sniff();
	}
	
	public void wagEar() {
		HelperClass.wait(1000);
		face.wagEar();
	}
	
	public void eat() {
		HelperClass.wait(1000);
		this.body.setVerticalLength(160);
		this.body.draw();
		face.eat();
	}
	
	public void sleep() {
		HelperClass.wait(1000);
		face.sleep();
	}
	
	public void digest() {
		HelperClass.wait(1000);
		this.body.erase();
		this.body.setVerticalLength(120);
		face.digest();
		this.body.draw();
	}
	
	public void draw() {
		tail.draw();
		leg2.draw();
		leg4.draw();
		body.draw();
		face.draw();
		leg1.draw();
		leg3.draw();
	}
	
}
