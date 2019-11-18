package de.bundeswehr.sheep;
import de.bundeswehr.graphics.Colour;
import de.bundeswehr.graphics.Ellipse;
import de.bundeswehr.graphics.HelperClass;

public class Head {

	private int xPos;
	private int yPos;
	private Ellipse face;
	Nostril leftNostril;
	Nostril rightNostril;
	Ear leftEar;
	Ear rightEar;
	Eye leftEye;
	Eye rightEye;
	
	Head(int x, int y, Colour initialColour){
		
		xPos = x;
		yPos = y;
		face = new Ellipse(80, 120, x, y, initialColour);
		leftNostril = new Nostril(x+20, y+84);
		rightNostril =  new Nostril(x+50,y+84);
		rightEar = new Ear(x-35, y+10, initialColour);
		leftEar = new Ear(x+66, y+10, initialColour);
		rightEye = new Eye(x+50, y+31, Colour.BLACK);
		leftEye = new Eye(x+10, y+31, Colour.BLACK);
		
	}
	
	void sniff() {
		this.rightNostril.sniff();
		this.leftNostril.sniff();
		HelperClass.wait(1000);
		rightNostril.unsniff();
		leftNostril.unsniff();
	}
	
	void wagEar() {
		this.leftEar.wagEar();
		HelperClass.wait(1000);
		this.leftEar.unwag();
	}
	
	void eat() {
		this.face.move(0, 90);
		this.rightEar.eat();
		this.leftEar.eat();
		this.rightEye.eat();
		this.leftEye.eat();
		this.rightNostril.eat();
		this.leftNostril.eat();
		this.face.draw();
		this.leftNostril.draw();
		this.rightNostril.draw();
		this.rightEye.draw();
		this.leftEye.draw();
		this.leftEar.draw();
		this.rightEar.draw();
		HelperClass.wait(1000);
		this.face.erase();
		this.face.move(0, -90);
		this.rightEar.uneat();
		this.leftEar.uneat();
		this.rightEye.uneat();
		this.leftEye.uneat();
		this.rightNostril.uneat();
		this.leftNostril.uneat();
		this.face.setColour(Colour.GREEN);
		this.face.draw();
		this.leftNostril.draw();
		this.rightNostril.draw();
		this.rightEye.draw();
		this.leftEye.draw();
		this.leftEar.draw();
		this.rightEar.draw();
	}
	
	void sleep() {
		leftEye.closeEyelid();
		rightEye.closeEyelid();
		HelperClass.wait(1000);
		leftEye.openEyelid();
		rightEye.openEyelid();
	}
	
	void digest() {
		face.erase();
		face.setColour(Colour.RED);
		this.leftEar.digest();
		this.rightEar.digest();
		face.draw();
		leftNostril.draw();
		rightNostril.draw();
		leftEar.draw();
		rightEar.draw();
		leftEye.draw();
		rightEye.draw();
	}
	
	
	void draw(){
		face.draw();
		leftNostril.draw();
		rightNostril.draw();
		leftEar.draw();
		rightEar.draw();
		leftEye.draw();
		rightEye.draw();
	}
	
}
