package sorting;

public class QUICKSORTwithPIVOT {

	
	    /* This function takes last element as pivot,
	       places the pivot element at its correct
	       position in sorted array, and places all
	       smaller (smaller than pivot) to left of
	       pivot and all greater elements to right
	       of pivot */
	    int partition(int arr[], int start, int end)
	    {
	        int pivot = arr[end]; 
	        int pI = (start-1); // index of smaller element i.e Pivot Index
	        for (int i=start; i<end; i++)
	        {
	            // If current element is smaller than or
	            // equal to pivot
	            if (arr[i] <= pivot)
	            {
	                pI++;
	                // swap arr[i] and arr[pI]
	                int temp = arr[pI];
	                arr[pI] = arr[i];
	                arr[i] = temp;
	            }
	        }
	 
	        // swap arr[i+1] and arr[high] (or pivot)
	        int temp = arr[pI+1];
	        arr[pI+1] = arr[end];
	        arr[end] = temp;
	        
	        return pI+1;
	    }
	 
	 
	    /* The main function that implements QuickSort()
	      arr[] --> Array to be sorted,
	      low  --> Starting index,
	      high  --> Ending index */
		void sort(int arr[], int low, int high)
	    {
	        if (low < high)
	        {
	            /* pi is partitioning index, arr[pi] is 
	              now at right place */
	            int pi = partition(arr, low, high);
	 
	            // Recursively sort elements before
	            // partition and after partition
	            sort(arr, low, pi-1);
	            sort(arr, pi+1, high);
	        }
	    }
	 
	    /* A utility function to print array of size n */
	    static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i]+" ");
	        System.out.println();
	    }
	 
	    // Driver program
	    public static void main(String args[])
	    {
	        int arr[] = {7,-2,1,6,8,5,3,4};
	        int n = arr.length;
	 
	        QUICKSORTwithPIVOT ob = new QUICKSORTwithPIVOT();
	        ob.sort(arr, 0, n-1);
	 
	        System.out.println("sorted array");
	        printArray(arr);
	    }
	

}
