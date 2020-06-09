

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Node{
	int data;
	Node left,right;
	public Node(int data) {
		this.data=data;
	}
}

public class InOrderTraversal {
	
	public static void main(String[] args) {
		Node ten = new Node(10);
		ten.left=new Node(5);
		ten.left.left=new Node(2);
		ten.left.right=new Node(7);
		ten.right=new Node(15);
		ten.right.left=new Node(12);
		ten.right.right=new Node(17);
		List<Integer> list = new ArrayList<>();
		inOrder(ten,list);
		for(Integer num : list) {
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.println("print itr in order");
		inOrderItr(ten);
		int[] arr1 = new int[] {4,5,6,9,12,43,56};
		int[] arr2 = new int[] {2,5,8,9,12,18,27,94};
		int i = 0;
		int j = arr2.length-1;
		int k = 30;
		int[] result = new int[2];
		while(i <= arr1.length && j >=0) {
			System.out.println(i + " " + j);
			int sum = arr1[i] + arr2[j];
			if( sum == k) {
				result[0]=i;
				result[1]=j;
				break;
			} else if (sum > k) {
				j--;
			} else if(sum < k) {
				i++;
			}
		}
		System.out.println(result[0] + " " + result[1]);
	}

	/*
	 * 
	 * create an empty stack
	 * set a ptr curr to root
	 * run a loop till curr is not null or stack has elements
	 * traverse left tree of curr till it is null and keep pushing to stack
	 * pop from stack, print it's data and set its right to curr
	 * 
	 */
	private static void inOrderItr(Node root) {
		if(root==null) {
			return;
		}
		Deque<Node> s = new ArrayDeque<>();
		Node curr = root;
		while(curr != null || s.size()>0) {
			while(curr != null) {
				s.push(curr);
				curr=curr.left;
			}
			curr=s.pop();
			System.out.print(curr.data+" ");
			curr=curr.right;
		}
	}

	private static void inOrder(Node root, List<Integer> list) {
		if(root == null) {
			return;
		}
		inOrder(root.left, list);
		list.add(root.data);
		inOrder(root.right, list);
	}

}
