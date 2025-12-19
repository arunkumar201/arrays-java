


const merge=(arr, low, mid, high) => {

	//[low...mid]
	//[mid+1...high]
	let left=low;
	let right=mid+1;

	const temp=[];
	let k=0;
	while (left<=mid && right<=high) {
		
		if (arr[left] <= arr[right]) {
			temp[k++]=arr[left++];
		} else {
			temp[k++]=arr[right++];
		}
	}

	while (left <= mid) temp[k++] = arr[left++];
	while (right<= high) temp[k++]=arr[right++];
	

	//copy the items into original arr
	  for (let i = 0; i < k; i++) {
			arr[low + i] = temp[i];
		}
	
}


const mergeSortAlgo=(arr, low, high) => {
	
	if (low>=high) return;
	const mid=Math.floor((low+high)/2);

	mergeSortAlgo(arr, low, mid);
	mergeSortAlgo(arr, mid+1, high);
	merge(arr, low, mid, high);
}


const arr=[1, 22, 3, 4, 5, 53, 3, 53, 0,2, -22, 2, 22];
mergeSortAlgo(arr, 0, arr.length-1);
console.log("After sorting",arr);
