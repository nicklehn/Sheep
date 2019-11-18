package de.bundeswehr.sheep;
import de.bundeswehr.graphics.Colour;
import de.bundeswehr.graphics.Ellipse;

public class Eye {

	private int xPos;
	private int yPos;
	private Ellipse iris;
	private Ellipse pupil;
	private Ellipse eyeLid;
	
	Eye(int x, int y, Colour initialColour) {
		
		xPos = x;
		yPos = y;
		iris = new Ellipse(20, 20, x, y, Colour.WHITE);
		pupil = new Ellipse(8, 8, x+6, y+7, initialColour);
		eyeLid = new Ellipse(20, 20, x, y-3, initialColour);
		
	}
	
	void eyeBlink(int x, int y, Colour initialColour) {
		
		xPos = x;
		yPos = y;
		iris = new Ellipse(20, 20, x, y, Colour.BLACK);
		pupil = new Ellipse(8, 8, x+6, y+7, Colour.BLACK);
		eyeLid = new Ellipse(20, 20, x, y-3, initialColour);
		iris.draw();
		eyeLid.draw();
		
	}
	
	void eat() {
		this.eyeLid.move(0, 90);
		this.pupil.move(0, 90);
		this.iris.move(0, 90);
		this.eyeLid.draw();
		this.iris.draw();
		this.pupil.draw();
	}
	
	void uneat() {
		this.eyeLid.erase();
		this.iris.erase();
		this.pupil.erase();
		this.eyeLid.move(0, -90);
		this.pupil.move(0, -90);
		this.iris.move(0, -90);
		this.eyeLid.draw();
		this.iris.draw();
		this.pupil.draw();
	}
	
	void closeEyelid() {
		this.iris.setColour(Colour.BLACK);
		this.eyeLid.setColour(Colour.GREEN);
		iris.draw();
		eyeLid.draw();
	}
	
	void openEyelid() {
		this.iris.erase();
		this.eyeLid.erase();
		this.iris.setColour(Colour.WHITE);
		this.eyeLid.setColour(Colour.BLACK);
		eyeLid.draw();
		iris.draw();
		pupil.draw();
	}
	
	
	
	void draw() {
		eyeLid.draw();	
		iris.draw();
		pupil.draw();
	}
	
}
