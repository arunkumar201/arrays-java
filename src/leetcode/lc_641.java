package leetcode;

public class lc_641 {
	
	public static void main(String[] args) {
		
		MyCircularDeque circularDeque = new MyCircularDeque(3);
		circularDeque.insertFront(1); // return true
		circularDeque.insertFront(2); // return true
		circularDeque.insertLast(3);  // return true
		circularDeque.insertLast(4);  // return true
		circularDeque.insertLast(5);  // return true
		System.out.println(circularDeque.getFront()); // return 1
		System.out.println(circularDeque.getRear()); // return 5
		System.out.println(circularDeque.deleteFront()); // return true
		System.out.println(circularDeque.deleteLast()); // return true
		System.out.println(circularDeque.isEmpty()); // return true
		System.out.println(circularDeque.isFull()); // return false
		
	}
}

//class MyCircularDeque {
//	LinkedList<Integer> linkedList;
//	int k;
//	int front;
//	int rear;
//	int size;
//
//	public MyCircularDeque(int k) {
//		this.k = k;
//		linkedList = new LinkedList<>();
//		front = -1;
//		rear = -1;
//		size = 0;
//	}
//
//	public boolean insertFront(int value) {
//		if (size >= k)
//			return false;
//
//		linkedList.addFirst(value);
//		if (front == -1) {
//			front = 0;
//			rear = 0;
//		} else {
//			front = (front + 1) % k;
//		}
//		size++;
//
//		return true;
//	}
//
//	public boolean insertLast(int value) {
//		if (size >= k)
//			return false;
//
//		linkedList.addLast(value);
//		if (rear == -1) {
//			front = 0;
//			rear = 0;
//		} else {
//			rear = (rear + 1) % k;
//		}
//		size++;
//
//		return true;
//	}
//
//	public boolean deleteFront() {
//		if (size == 0)
//			return false;
//
//		linkedList.removeFirst();
//		if (front == rear) {
//			front = -1;
//			rear = -1;
//		} else {
//			front = (front + 1) % k;
//		}
//		size--;
//
//		return true;
//	}
//
//	public boolean deleteLast() {
//		if (size == 0)
//			return false;
//
//		linkedList.removeLast();
//		if (front == rear) {
//			front = -1;
//			rear = -1;
//		} else {
//			rear = (rear - 1 + k) % k;
//		}
//		size--;
//
//		return true;
//	}
//
//	public int getFront() {
//		return linkedList.isEmpty() ? -1 : linkedList.getFirst();
//	}
//
//	public int getRear() {
//		return linkedList.isEmpty() ? -1 : linkedList.getLast();
//	}
//
//	public boolean isEmpty() {
//		return linkedList.isEmpty();
//	}
//
//	public boolean isFull() {
//		return size == k;
//	}
//}


// Using Array
class MyCircularDeque {
    int[] arr;
    int front = 0, rear = 0, size = 0;

    public MyCircularDeque(int k) {
         arr = new int[k];
    }
    
    public boolean insertFront(int value) {
        if(isFull())  return false;
        //if front=0 then (-1)%3 = -1, so handle this we can add size
        front = (front - 1 + arr.length) % arr.length;
        arr[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        arr[rear] = value;
        rear = (rear + 1) % arr.length;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        front = (front + 1) % arr.length;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
      //if rear=0 then (-1)%3 = -1, so handle this we can add size
        rear = (rear - 1 + arr.length) % arr.length;
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return arr[front];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return arr[(rear - 1 + arr.length) % arr.length];
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public boolean isFull() {
        return (size == arr.length);
    }
}