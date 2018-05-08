package eg.edu.alexu.csd.filestructure.avl.cs23;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		long startTime = System.currentTimeMillis();
//
		 Dictionary d = new Dictionary();
//		 d.insert("a");
//		 d.insert("y");
//		 d.insert("z");
////		 d.insert("p");
////		 d.insert("f");
//
//		 d.printDictionary();
//		 System.out.println(d.size());
//		 System.out.println(d.height());
		 File input = new File("E:\\Eng\\Eng 3\\Eng 3-2\\Data Structure II\\" +
				 "Labs\\Online Tester in shwal\\avl\\res\\dictionary.txt");
		try {
			d.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(d.size());
		 System.out.println(d.height());
//
//		 d.printDictionary();
//		long stopTime = System.currentTimeMillis();
//		long elapsedTime = stopTime - startTime;
//		System.out.println(elapsedTime);
//		AVLTree t = new AVLTree();
//		t.insert(20);
//		t.insert(15);
//		t.insert(13);
//		t.insert(90);
//		t.insert(60);
//		t.insert(21);
//		t.insert(80);
//		t.insert(17);
//		t.insert(15);
//		t.printPreorder(t.root);
//
//		System.out.println((((Node<Integer>)t.root.getRightChild()).getHeight()));
//
//		System.out.println("Root: " + t.root + ". Right: " + t.root.getRightChild() + ". Left: " + t.root.getLeftChild());
//
//		AVLTree avl = new AVLTree();
//
//		int[] input = {13, 8, 5, 9, 4, 6, 12, 2, 1, 3};
//// int[] height = {0,1,1,2,2,2,2,3,3,3};
//		int[] height = {1, 2, 2, 3, 3, 3, 3, 4, 4, 4};
//
//		for (int i = 1; i<1000; ++i){
//			avl.insert(i);
	}

}
