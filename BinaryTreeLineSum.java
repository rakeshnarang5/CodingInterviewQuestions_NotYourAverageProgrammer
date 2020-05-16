package com.airtelbank.upiswitch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// we will need a node to create binary tree
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

public class BinaryTreeLineSum {

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

		// we will use a map to store the line sums
		Map<Integer, Integer> lineNoSumMap = new HashMap<>();

		// we will calculate line sum
		calcLineSum(lineNoSumMap, root, 0);

		// and print line sum
		printLineSum(lineNoSumMap);
	}

	// printLineSum is a method where we will first sort the keys and then print sum
	private static void printLineSum(Map<Integer, Integer> lineNoSumMap) {
		// keySet on a map will return an unordered set, we will convert it to a list
		List<Integer> unsorted = new ArrayList<>(lineNoSumMap.keySet());
		// and sort it
		Collections.sort(unsorted);
		// we will keep a ptr init at 1
		int lineNo = 1;
		// we will then iterate over sorted keys, print sum and increment line numbers
		for (Integer key : unsorted) {
			System.out.println("Line Number: " + lineNo + " -> Sum: " + lineNoSumMap.get(key));
			lineNo++;
		}
	}

	// calcLineSum method will have three params
	// lineNoSumMap -> it will hold the offFromCentre i.e. the line no. as key and
	// sum as value
	// root -> is the node we are currently traversing
	// offFromCentre -> the line off from centre
	private static void calcLineSum(Map<Integer, Integer> lineNoSumMap, Node root, int offFromCentre) {
		// if root is null, we return, no more processing
		if (root == null) {
			return;
		}
		// for this op, we start with sum 0
		int sum = 0;
		// if map already contains a sum previously calculate for the line, we will set
		// sum to
		// previously calculated sum
		if (lineNoSumMap.containsKey(offFromCentre)) {
			sum = lineNoSumMap.get(offFromCentre);
		}
		// we will add current node data to sum
		sum += root.data;
		// and put the new sum back to map for that line
		lineNoSumMap.put(offFromCentre, sum);
		// we will calcLineSum for left node with offFromCentre -1
		calcLineSum(lineNoSumMap, root.left, offFromCentre - 1);
		// we will calcLineSum for right node with offFromCentre + 1
		calcLineSum(lineNoSumMap, root.right, offFromCentre + 1);
	}

}
