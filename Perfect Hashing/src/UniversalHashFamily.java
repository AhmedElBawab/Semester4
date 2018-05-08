import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class UniversalHashFamily {
	
	// Setting hash Size
	private int b;

	// ArrayList of Hashing Functions
	private ArrayList<Integer []> hashFamily = new ArrayList<Integer []>();
	
	public void setHashSize(int b){
		this.b = b ;
		this.buildHashFamily();
	}

	private void buildHashFamily() {
		// The Generated Hash Function
		for (int j = 0; j < 100; j++) {
			Integer [] h = new Integer[this.b];
			// The loop to generate The function
			for (int i = 0; i < this.b; i++) {
				h[i] = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
			}
			this.hashFamily.add(h);
		}
	}

	public ArrayList<Integer []> getHashFamily() {
		return this.hashFamily;
	}
}
