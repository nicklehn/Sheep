import de.bundeswehr.graphics.Colour;
import de.bundeswehr.sheep.Sheep;

public class Main {

	public static void main(String[] args) {
		
		Sheep body1 = new Sheep(170, 100, Colour.RED);
		body1.draw();
	
		body1.sniff();
		
		body1.wagEar();
		
		body1.eat();
		
		body1.sleep();
		
		body1.digest();
		

		
	
		
	}

}
