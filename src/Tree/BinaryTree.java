package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
	private Node root;
	private boolean printStarted = false;
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.buildTree();
		
		System.out.println("---- Pre-order traversal ----");
		tree.preOrderTraversal();
		
		System.out.println("---- In-order traversal ----");
		tree.inOrderTraversal();
		
		System.out.println("---- Post-order traversal ----");
		tree.postOrderTraversal();
		
		System.out.println("---- Level order traversal ----");
		tree.levelOrderTraversal();
		
		System.out.println("---- Count nodes ----");
		System.out.println(tree.countNodes());
	}
	
	public void buildTree() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the value for the root node: ");
			int value = scanner.nextInt();
			root = new Node(value);
			populateChildren(root, scanner);
		} catch (Exception e) {
			System.err.println("Error reading input: " + e.getMessage());
		}
	}
	
	private void populateChildren(Node current, Scanner scanner) {
		// Left child
		System.out.printf("Add left child of %d? (1 = Yes, 0 = No): ", current.value);
		if (scanner.nextInt() == 1) {
			System.out.printf("Enter left child value for %d: ", current.value);
			int leftValue = scanner.nextInt();
			current.left = new Node(leftValue);
			populateChildren(current.left, scanner);
		}
		
		// Right child
		System.out.printf("Add right child of %d? (1 = Yes, 0 = No): ", current.value);
		if (scanner.nextInt() == 1) {
			System.out.printf("Enter right child value for %d: ", current.value);
			int rightValue = scanner.nextInt();
			current.right = new Node(rightValue);
			populateChildren(current.right, scanner);
		}
	}
	
	// Pre-order traversal: root -> left_subtree -> right_subtree
	// Time: O(n), Space: O(h)
	public void preOrderTraversal() {
		printStarted = false;
		preOrder(helperNullCheck(root));
		System.out.println();
	}
	
	
	private void preOrder(Node node) {
		if (node == null) return;
		printValue(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	// In-order traversal: left_subtree -> root -> right_subtree
	// Time: O(n), Space: O(h)
	public void inOrderTraversal() {
		printStarted = false;
		inOrder(helperNullCheck(root));
		System.out.println();
	}
	
	private void inOrder(Node node) {
		if (node == null) return;
		inOrder(node.left);
		printValue(node.value);
		inOrder(node.right);
	}
	
	// Post-order traversal: left_subtree -> right_subtree -> root
	// Time: O(n), Space: O(h)
	public void postOrderTraversal() {
		printStarted = false;
		postOrder(helperNullCheck(root));
		System.out.println();
	}
	
	// Level order traversal: root -> left_subtree -> right_subtree
	// Time: O(n),
	public void levelOrderTraversal() {
		printStarted = false;
		levelOrder(helperNullCheck(root));
		System.out.println();
	}
	
	private void postOrder(Node node) {
		if (node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		printValue(node.value);
	}
	
	private void levelOrder(Node node) {
		if (node == null) return;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			printValue(current.value);
			//immediately add the children for the current node into queue
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}
	}
	
	private void printValue(int value) {
		if (printStarted) {
			System.out.print(" -> ");
		}
		System.out.print(value);
		printStarted = true;
	}
	
	// Null check before traversal
	private Node helperNullCheck(Node node) {
		if (node == null) {
			System.out.println("The tree is empty.");
		}
		return node;
	}
	
	
	//count of nodes in the tree
	// Time: O(n) and space: O(h)
	public int countNodes() {
		return countNodesHelper(root);
	}
	
	//Sum of all the nodes in the tree
	// Time: O(n) and space: O(h)
	public int sumNodes() {
		return sumNodesHelper(root);
	}
	
	//time: O(n) and space: O(h)
	public int heightOfTree() {
		return heightOfTreeHelper(root);
	}
	
	private int depthOfNode(Node target) {
		return depthOfNodeHelper(root, target, 0);
	}
	
	private int depthOfNodeHelper(Node current, Node target, int currentDepth) {
		if (current == null) {
			return -1;
		}
		if (current == target) {
			return currentDepth;
		}
		// Search left subtree
		int leftDepth = depthOfNodeHelper(current.left, target, currentDepth + 1);
		if (leftDepth != -1) {
			return leftDepth;
		}
		return depthOfNodeHelper(current.right, target, currentDepth + 1);
	}
	
	
	private int heightOfTreeHelper(Node node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = heightOfTreeHelper(node.left);
		int rightHeight = heightOfTreeHelper(node.right);
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	private int sumNodesHelper(Node node) {
		if (node == null) {
			return 0;
		}
		int leftNodes = sumNodesHelper(node.left);
		int rightNodes = sumNodesHelper(node.right);
		
		return node.value + leftNodes + rightNodes;
	}
	
	
	private int countNodesHelper(Node node) {
		if (node == null) {
			return 0;
		}
		int leftNodes = countNodesHelper(node.left);
		int rightNodes = countNodesHelper(node.right);
		
		return 1 + leftNodes + rightNodes;
	}
	
	// Node class
	private static class Node {
		int value;
		Node left, right;
		
		Node(int value) {
			this.value = value;
		}
	}
}
