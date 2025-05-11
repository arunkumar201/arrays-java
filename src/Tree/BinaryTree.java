package Tree;

import java.util.Scanner;

public class BinaryTree {
	private Node root;
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.buildTree();
		tree.preOrderTraversal();
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
	
	public void preOrderTraversal() {
		preOrder(helperNullCheck(root), "");
		System.out.println();
	}
	
	private void preOrder(Node node, String indent) {
		if (node == null) {
			return;
		}
		System.out.println(indent + node.value);
		preOrder(node.left, indent + "\t");
		preOrder(node.right, indent + "\t");
	}
	
	
	private Node helperNullCheck(Node node) {
		if (node == null) {
			System.out.println("The tree is empty.");
		}
		return node;
	}
	
	private static class Node {
		int value;
		Node left;
		Node right;
		
		Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
}