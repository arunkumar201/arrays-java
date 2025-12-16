package sorting;

import java.util.Arrays;

public class QuickSortAlgo {
	public static void main(String[] args) {
		int[] arr = {110, 100, 0};
		QuickSortAlgo sol = new QuickSortAlgo();
		sol.quickSort(arr, 0, arr.length - 1);
		System.out.println("Quick Sort : " + Arrays.toString(arr));
	}

	public void quickSort(int[] arr, int low, int high) {
		// Base condition - if the partition has 0 or 1 element, it's already sorted
		if (low >= high)
			return;

		// Partition the array and get the pivot's final position
		int pivotIndex = partition(arr, low, high);

		// Recursively sort the left partition (elements smaller than pivot)
		quickSort(arr, low, pivotIndex - 1);

		// Recursively sort the right partition (elements greater than pivot)
		quickSort(arr, pivotIndex + 1, high);
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public int partition(int[] arr, int low, int high) {
		// Choose the first element as the pivot
		int pivot = arr[low];

		// Initialize two pointers: i starts after pivot, j starts at the end
		int i = low + 1;
		int j = high;

		while (i <= j) {
			// Move i forward until we find an element > pivot
			// These elements need to be on the right side
			while (i <= j && arr[i] <= pivot) {
				i++;
			}

			// Move j backward until we find an element < pivot
			// These elements need to be on the left side
			while (i <= j && arr[j] > pivot) {
				j--;
			}

			// If pointers haven't crossed, swap the misplaced elements
			if (i < j) {
				swap(arr, i, j);
			}
		}

		// At this point, j points to the last element smaller than pivot
		// Swap the pivot with arr[j] to place it in its correct sorted position
		swap(arr, low, j);

		// Return the pivot's final index
		// All elements before j are < pivot, all elements after j are >= pivot
		return j;
	}
}
