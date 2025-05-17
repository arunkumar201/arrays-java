package Tree;

import java.util.Scanner;

public class BinaryTree {
    private Node root;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.buildTree();

        System.out.println("---- Pre-order traversal ----");
        tree.preOrderTraversal();

        System.out.println("---- In-order traversal ----");
        tree.inOrderTraversal();

        System.out.println("---- Post-order traversal ----");
        tree.postOrderTraversal();
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

    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        printValue(node.value);
    }

    private boolean printStarted = false;

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

    // Node class
    private static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }
}
