package eg.edu.alexu.csd.filestructure.sort.cs23;

import java.util.ArrayList;

public class TimeTest {
	
	public void PrintTime(ArrayList unordered) {
		
		Sort s = new Sort();
		
		long startTime = System.currentTimeMillis();
		s.heapSort(unordered);
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.print(elapsedTime);
	    System.out.print("                ");
	    
	    startTime = System.currentTimeMillis();
	    s.sortSlow(unordered);
	    stopTime = System.currentTimeMillis();
	    elapsedTime = stopTime - startTime;
	    System.out.print(elapsedTime);
	    System.out.print("                ");
	    
	    startTime = System.currentTimeMillis();
	    s.sortFast(unordered);
	    stopTime = System.currentTimeMillis();
	    elapsedTime = stopTime - startTime;
	    System.out.print(elapsedTime);
	    System.out.println("                ");
	    
	}

}
