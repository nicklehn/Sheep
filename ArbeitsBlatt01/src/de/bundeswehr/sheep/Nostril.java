package de.bundeswehr.sheep;
import de.bundeswehr.graphics.Colour;
import de.bundeswehr.graphics.Ellipse;

public class Nostril {

	private int xPos;
	private int yPos;
	private Ellipse nostril;
	
	Nostril(int x, int y){
		xPos = x;
		yPos = y;
		nostril = new Ellipse(10, 10, x, y, Colour.BLACK);
	}
	
	void sniff() {
		this.nostril.setHorizontalLength(18);
		this.nostril.setVerticalLength(18);
		this.nostril.move(-4, -4);
		this.nostril.draw(); 
	}
	
	void unsniff() {
		this.nostril.erase();
		this.nostril.setHorizontalLength(10);
		this.nostril.setVerticalLength(10);
		this.nostril.move(4, 4);
		this.nostril.draw();	
	}
	
	void eat() {
		this.nostril.move(0, 90);
		this.nostril.draw();
	}
	
	void uneat() {
		this.nostril.erase();
		this.nostril.move(0, -90);
		this.nostril.draw();
	}
	
	
	void draw(){
		nostril.draw();
	}
	
}
