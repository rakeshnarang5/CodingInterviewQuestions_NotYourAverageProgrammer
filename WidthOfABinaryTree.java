//we will need a node to create binary tree
class Node {
	// it has data
	int data;
	// left node
	Node left;
	// right node
	Node right;

	// and a constructor
	public Node(int data) {
		this.data = data;
	}
}

public class WidthOfABinaryTree {

	public static void main(String[] args) {
		// we first create nodes
		Node ten = new Node(10);
		Node twenty = new Node(20);
		Node thirty = new Node(30);
		Node forty = new Node(40);
		Node root = new Node(50);
		Node sixty = new Node(60);
		Node seventy = new Node(70);
		Node eighty = new Node(80);
		Node ninety = new Node(90);

		// and then link them to create a tree
		root.left = thirty;
		root.right = seventy;
		thirty.left = twenty;
		thirty.right = forty;
		twenty.left = ten;
		seventy.left = sixty;
		seventy.right = eighty;
		eighty.right = ninety;

		int[] height = new int[1];

		findHeightOfBinaryTree(root, height, 0);

		System.out.println("Height of Binary Tree is: " + height[0]);

		int[] levelElements = new int[height[0] + 1];

		findElementsAtEachLevel(root, levelElements, 0);

		System.out.println("Max Width is: " + findMaxWidth(levelElements));

	}

	// at each level of a tree, at most, 2^level elements can exist
	// for e.g. at level 0 -> 2^0 i.e. 1 element can exist
	// at level 2 -> 2^2 i.e. 4 elements can exist
	private static int findMaxWidth(int[] levelElements) {
		int maxWidth = 0;
		// so in code, we will break when an incomplete level is found
		// when we find such a level
		// level previous to it is complete and number of elements in that level will
		// give us the width of the tree
		for (int i = 0; i < levelElements.length; i++) {
			if (levelElements[i] != Math.pow(2, i))
				maxWidth = levelElements[i - 1];
		}
		return maxWidth;
	}

	// time complexity of this method is O(n)
	private static void findElementsAtEachLevel(Node root, int[] levelElements, int level) {
		// if current node is null, we return
		if (root == null) {
			return;
		}
		levelElements[level]++;
		// once we process current node
		// we first move to left part of the tree
		findElementsAtEachLevel(root.left, levelElements, level + 1);
		// and then we move to the right part of the tree
		findElementsAtEachLevel(root.right, levelElements, level + 1);
	}

	// time complexity of this method is O(n)
	private static void findHeightOfBinaryTree(Node root, int[] height, int level) {
		// if current node is null, we return
		if (root == null) {
			return;
		}
		// if level is greater than height already seen, we set height as max
		if (level > height[0])
			height[0] = level;
		// once we process current node
		// we first move to left part of the tree
		findHeightOfBinaryTree(root.left, height, level + 1);
		// and then we move to the right part of the tree
		findHeightOfBinaryTree(root.right, height, level + 1);
	}

}
