package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc_1352 {
	
	public static void main(String[] args) {
		ProductOfNumbers productOfNumbers = new ProductOfNumbers();
		productOfNumbers.add(3);    // [3]
		productOfNumbers.add(0);    // [3, 0]
		productOfNumbers.add(2);    // [3, 0, 2]
		productOfNumbers.add(5);    // [3, 0, 2, 10]
		System.out.println(productOfNumbers.getProduct(2)); // return 20 (the product of numbers in the range [2, 2])
		productOfNumbers.add(8);    // [3, 0, 2, 10, 24]
		System.out.println(productOfNumbers.getProduct(5)); // return 40 (the product of numbers in the range [1, 5])
		
	}
	
}


class ProductOfNumbers {
    List<Integer> prefixProduct;

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefixProduct.clear();
            prefixProduct.add(1);
        } else {
            int lastProduct = prefixProduct.getLast();
            prefixProduct.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {
        int size = prefixProduct.size();
        if (k > size) {
            return 0;
        }
        return prefixProduct.get(size - 1) / prefixProduct.get(size - 1 - k);
    }
}
