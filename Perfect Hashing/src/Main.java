import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Getting File Path
		File file = new File("D:\\Mine\\Faculty\\DataStructures\\Perfect Hashing\\src\\test.txt");
		// Reading File
		ReadFile r = new ReadFile(file);
		// Creating Hash Family
		UniversalHashFamily h = new UniversalHashFamily();
		h.setHashSize((int) Math.ceil(Math.log(r.getSource().length) / Math.log(2)));
		
		Method01 m1 = new Method01(h.getHashFamily() , (int) Math.ceil(Math.log(r.getSource().length) / Math.log(2)) );
		m1.insert(r.getSource());
		
		System.out.println(m1.find(4));
		System.out.println(m1.find(-5));
		System.out.println(m1.find(-6));
		System.out.println(m1.find(13));
		System.out.println(m1.find(3));
		System.out.println(m1.find(1000000000));
	}

}
