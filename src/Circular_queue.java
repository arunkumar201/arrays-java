//public class Circular_queue {
//
//	public static void main(String[] args) {
//
//		MyCircularQueue circularQueue = new MyCircularQueue(3);
//	}
//}
//
//class MyCircularQueue {
//	int[] arr;
//	int size;
//	int rear, front;
//	int k;
//
//
//	public MyCircularDeque(int k) {
//		arr = new int[k];
//		this.k = k;
//		rear = -1;
//		front = -1;
//		size = 0;
//	}
//
//	public boolean insertFront(int value) {
//		if (isFull()) {
//			return false;
//		}
//		if (front == -1) {
//			front = 0;
//			rear = 0;
//		} else {
//			front = (front + 1) % k;
//
//		}
//		arr[front] = value;
//		size++;
//		return false;
//	}
//
//	public boolean insertLast(int value) {
//		//check the overflow
//		if (isFull()) {
//			return false;
//		}
//		if (rear == -1) {
//			front = 0;
//			rear = 0;
//		} else {
//			rear = (rear + 1) % k;
//		}
//		arr[rear] = value;
//		size++;
//		return true;
//	}
//
//	public boolean deleteFront() {
//		if (isEmpty()) {
//			return false;
//		}
//		if (front == rear) {
//			front = -1;
//			rear = -1;
//		} else {
//			front = (front + 1) % k;
//		}
//		size--;
//		return true;
//	}
//
//	public boolean deleteLast() {
//		if (isEmpty()) {
//			return false;
//		}
//		if (rear == front) {
//			front = -1;
//			rear = -1;
//		} else {
//			rear = (rear - 1 + k) % k;
//		}
//		size--;
//		return true;
//	}
//
//	public int getFront() {
//		if (isEmpty()) {
//			return -1;
//		}
//		return arr[front];
//	}
//
//	public int getRear() {
//		if (isEmpty()) {
//			return -1;
//		}
//		return arr[rear];
//
//	}
//
//	public boolean isEmpty() {
//		return size == 0;
//	}
//
//	public boolean isFull() {
//		return size == k;
//
//	}
//
//}
