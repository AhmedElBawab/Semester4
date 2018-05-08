import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadFile {

	// Creating The ArrayList of integers
	private ArrayList<Integer> source = new ArrayList<Integer>();

	public ReadFile(File file) {
		// Creating File Reader
		FileReader inputFile = null;
		try {
			inputFile = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// Creating Buffer Reader
		BufferedReader in = new BufferedReader(inputFile);
		String s = null;
		try {
			s = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (s != null) {
			source.add(Integer.parseInt(s));
			try {
				s = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Check if file is Empty
		if (source.size() == 0){
			throw null;
		}
	}
	
	public int[] getSource(){
		int[] ret = new int[this.source.size()];
	    Iterator<Integer> iterator = this.source.iterator();
	    for (int i = 0; i < ret.length; i++)
	    {
	        ret[i] = iterator.next().intValue();
	    }
	    return ret;
	}
	
}
