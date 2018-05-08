package eg.edu.alexu.csd.filestructure.sort.cs23;
import java.awt.ItemSelectable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import org.omg.CORBA.ObjectHolder;
import eg.edu.alexu.csd.filestructure.sort.IHeap;
import eg.edu.alexu.csd.filestructure.sort.ISort;
public class Sort<T extends Comparable<T>> implements ISort<T> {
	
    @Override
    public IHeap<T> heapSort(ArrayList<T> unordered) {
        MaxHeap<T> heap = new MaxHeap<>();
        heap.build(unordered);
        //System.out.println(heap.getRoot().getValue());
        
    
        for(int i = 0; i < heap.items.size(); i++){
            for(int j = i + 1; j < heap.items.size(); j++){
                if(heap.items.get(i).getValue().compareTo(heap.items.get(j).getValue()) >0){
                    
                    T temp = heap.items.get(i).getValue();
                    heap.items.get(i).setValue(heap.items.get(j).getValue());
                    heap.items.get(j).setValue(temp);
                }
            }
        }
        /*
        for(Node<T> item: heap.items){
            System.out.println("Item: " + 
        item.getValue());
        }
        */
        return heap;
    }


	@Override
	public void sortSlow(ArrayList<T> unordered) {
		// TODO Auto-generated method stub
		BubbleSort b = new BubbleSort();
		b.bubbleSort(unordered, unordered.size());
	}

	@Override
	public void sortFast(ArrayList<T> unordered) {
		// TODO Auto-generated method stub
		QuickSort q = new QuickSort();
		q.sort(unordered, 0, unordered.size()-1);
	}

}
