

public class TreeExample {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		// print the tree
		printTree(root, 0);

		// check if the tree contains the value 5
		System.out.println(searchTree(root, 50));
	}

	public static void printTree(TreeNode root, int level) {
		printTreeHelper(root, level);
	}

	private static void printTreeHelper(TreeNode node, int level) {
		if (node == null) {
			return;
		}

		// Print right subtree first for
		printTreeHelper(node.right, level + 1);

		// Print current node with branches
		System.out.println(" ".repeat(level * 4) + "|-- " + node.data);

		// Print left subtree
		printTreeHelper(node.left, level + 1);
	}

	public static boolean searchTree(TreeNode root, int value) {
		return searchTreeHelper(root, value);
	}

	// time complexity: O(n)
	private static boolean searchTreeHelper(TreeNode node, int value) {
		if (node == null) {
			return false;
		}
		if (node.data == value) {
			return true;
		}
		// search left subtree
		if (searchTreeHelper(node.left, value)) {
			return true;
		}
		// search right subtree
		return searchTreeHelper(node.right, value);
	}

	// time complexity: O(n)
	public static void insertTree(TreeNode root, int value) {
		insertTreeHelper(root, value);
	}

	private static TreeNode insertTreeHelper(TreeNode node, int value) {
		if (node == null) {
			return new TreeNode(value);
		}

	}

}
