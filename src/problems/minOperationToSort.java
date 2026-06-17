package problems;

import java.util.Collections;
import java.util.LinkedList;

/*
 * 
 * You are given a list of integers.
Your task is to sort the list into non-decreasing order using the following specific operation:

🔹 Operation (counts as 1 move)

Take the first element of the list.

Move it to the end of the list.

Then repeatedly swap it backward with the previous element until it is greater than or equal to the previous element.

Repeat this operation until the entire list becomes sorted in non-decreasing order.
Return the total number of operations required to sort the list.
 */
public class minOperationToSort {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		Collections.addAll(list, 4, 3, 2, 1, 5);
        minOperationToSort minOperationToSort = new minOperationToSort();
		int operations = minOperationToSort.sortWithCustomOperation(list);

		System.out.println("Sorted List: " + list);
		System.out.println("Operations needed: " + operations);
	}

	public boolean isSorted(LinkedList<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) < list.get(i - 1)) {
				return false;
			}
		}
		return true;
	}

	public int sortWithCustomOperation(LinkedList<Integer> list) {
		int count = 0;

		//if list is already sorted
		if (isSorted(list)) {
			return 0;
		}

		while (!isSorted(list)) {
			count++;
			int firstElement = list.removeFirst();

			//add it to the end
			list.addLast(firstElement);

			//repeat until it is greater than or equal to the previous element
			for(int i=list.size()-1;i>0;i--) {
				if(list.get(i)<list.get(i-1)) {
					int temp = list.get(i);
					list.set(i, list.get(i-1));
					list.set(i-1, temp);
				} else {
					break;
				}
			}
			
		}

		return count;
	}
}
