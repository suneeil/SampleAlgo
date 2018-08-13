package sorting;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7};		  
		System.out.println("Given Array");
		printArray(arr);
		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length-1);	 
		System.out.println("\nSorted array");
		printArray(arr);
	}
	void merge(int arr[], int low, int mid, int high)
	{
		// Find sizes of two subarrays to be merged
		int leftTOT = mid - low + 1;
		int rightTOT = high - mid;
		/* Create temp arrays */
		int leftArrL[] = new int [leftTOT];
		int rightArr[] = new int [rightTOT];
		/*Copy data to temp arrays*/
		for (int i=0; i<leftTOT; ++i)
			leftArrL[i] = arr[low + i];
		for (int j=0; j<rightTOT; ++j)
			rightArr[j] = arr[mid + 1+ j];
		/* Merge the temp arrays */
		// Initial indexes of first and second subarrays
		int leftArrIndex = 0, rightArrIndex = 0;
		// Initial index of merged subarry array
		int k = low;
		while (leftArrIndex < leftTOT && rightArrIndex < rightTOT)
		{
			if (leftArrL[leftArrIndex] <= rightArr[rightArrIndex])
			{
				arr[k] = leftArrL[leftArrIndex];
				leftArrIndex++;
			}
			else
			{
				arr[k] = rightArr[rightArrIndex];
				rightArrIndex++;
			}
			k++;
		}
		/* Copy remaining elements of L[] if any */
		while (leftArrIndex < leftTOT)
		{
			arr[k] = leftArrL[leftArrIndex];
			leftArrIndex++;
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (rightArrIndex < rightTOT)
		{
			arr[k] = rightArr[rightArrIndex];
			rightArrIndex++;
			k++;
		}
	}			
	// merge()
	void sort(int arr[], int left, int right)
	{
		if (left < right)
		{
			// Find the middle point
			int mid = (left+right)/2;

			// Sort first and second halves
			sort(arr, left, mid);
			sort(arr , mid+1, right);
			System.out.println("Left: "+arr[left]+", Right: "+arr[right]);
			// Merge the sorted halves
			merge(arr, left, mid, right);
		}
	}    
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
