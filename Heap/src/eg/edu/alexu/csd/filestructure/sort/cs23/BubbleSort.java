package eg.edu.alexu.csd.filestructure.sort.cs23;

import java.util.ArrayList;

public class BubbleSort {

    static void bubbleSort(ArrayList unordered, int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) 
        {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) 
            {
                if ((int)unordered.get(j) > (int)unordered.get(j+1)) 
                {
                    // swap
                    temp = (int)unordered.get(j);
                    unordered.set(j, unordered.get(j+1));
                    unordered.set(j+1, temp);
                    swapped = true;
                }
            }
 
            // IF no two elements were 
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
    
}
