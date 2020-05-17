package com.airtelbank.upiswitch;

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

public class HeightOfBinaryTree {

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

	}

	private static void findHeightOfBinaryTree(Node root, int[] height, int level) {
		if (root == null) {
			return;
		}
		if (level > height[0])
			height[0] = level;
		findHeightOfBinaryTree(root.left, height, level + 1);
		findHeightOfBinaryTree(root.right, height, level + 1);
	}

}
