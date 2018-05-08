package eg.edu.alexu.csd.filestructure.sort.cs23;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TimeTest t = new TimeTest();
		
		Random randomGenerator = new Random();
		
		ArrayList<Object> unordered = new ArrayList<Object>();
	    
	    for(int i = 0 ; i <1000 ; i++) {
		    for (int idx = 1; idx <= 10000; ++idx){
		    	unordered.add(randomGenerator.nextInt(1000000000));
		    }
		    
		    t.PrintTime(unordered);
		    unordered.clear();
	    }
	   
	}

}
