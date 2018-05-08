package eg.edu.alexu.csd.filestructure.sort.cs23;

import java.util.ArrayList;

public class QuickSort {

	int partition(ArrayList unordered, int low, int high)
    {
        int pivot = (int) unordered.get(high); 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
        	int swapper = (int) unordered.get(j);
            if (swapper <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = (int) unordered.get(i);
                unordered.set(i, unordered.get(j));
                unordered.set(j, temp);
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = (int) unordered.get(i+1);
        unordered.set(i+1, unordered.get(high));
        unordered.set(high, temp);
 
        return i+1;
    }
 
 
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(ArrayList unordered, int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partition(unordered, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            sort(unordered, low, pi-1);
            sort(unordered, pi+1, high);
        }
    }
    
}
