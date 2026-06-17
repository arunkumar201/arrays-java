package sorting;

public class MergeSortAlgo {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 5, 6, 7, 8, 33, 1, 2, 3, 45, 5, 0 };

		MergeSortAlgo sol = new MergeSortAlgo();
		sol.mergeSort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}


	//time complexity=O(N*logN) - N=worst case for merge fun , logN - we are dividing into half at each stage 
	public void mergeSort(int[] arr, int low, int high) {

		//base case - when low an high are equal or start>= crosses high
		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2;

		//apply merge sort from low to mid 
		mergeSort(arr, low, mid);
		//apply merge sort from mid+1 to high 
		mergeSort(arr, mid + 1, high);

		//let's merge the arr from low to mid then mid to high 
		merge(arr, low, mid, high);  //O(N) in worst case 
	}

	private void merge(int[] arr, int low, int mid, int high) {

		//size would be (high - low + 1)
		int[] temp = new int[high - low + 1];
		//[low...mid]
		//[mid+1...high]
		int left= low;
		int right = mid + 1;

		int k=0;
		while (left <= mid && right <= high) {
			if (arr[left] <= arr[right]) {
				temp[k++] = arr[left];
				left++;
			} else {
				temp[k++] = arr[right];
				right++;
			}
		}
		while (left <= mid) {
			temp[k++] = arr[left++];
		}
		while (right <= high) {
			temp[k++] = arr[right++];
		}
		//lets copy the items from temp to original array 
		for (int i = low; i <= high; i++) {
			arr[i] = temp[i - low];
		}
	}
}
