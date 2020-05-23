import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.valueOf(this.data);
	}
}

public class GroupLinkedListProblem {

	public static void main(String[] args) {
		Node[] nodeArr = new Node[6];
		generateLinkedListBucket(nodeArr);
		Map<Node, List<Integer>> groupMap = new HashMap<>();
		groupLinkedLists(nodeArr, groupMap);
		List<List<Integer>> result = computerResultFromGroupMap(groupMap);
		System.out.println("GroupLinkedListProblem Validation Result: " + validateResult(result));
	}

	private static boolean validateResult(List<List<Integer>> result) {
		List<List<Integer>> expectedResult = new ArrayList<>();
		expectedResult.add(Arrays.asList(0, 1));
		expectedResult.add(Arrays.asList(2));
		expectedResult.add(Arrays.asList(3, 4));
		expectedResult.add(Arrays.asList(5));
		for (List<Integer> list : result) {
			if (!expectedResult.contains(list)) {
				return false;
			}
		}
		return true;
	}

	private static List<List<Integer>> computerResultFromGroupMap(Map<Node, List<Integer>> groupMap) {
		List<List<Integer>> result = new ArrayList<>();
		result.addAll(groupMap.values());
		return result;
	}

	private static void groupLinkedLists(Node[] nodeArr, Map<Node, List<Integer>> groupMap) {
		for (int i = 0; i < nodeArr.length; i++) {
			Node start = nodeArr[i];
			while (start != null) {
				if (start.next == null) {
					List<Integer> list = groupMap.getOrDefault(start, new ArrayList<>());
					list.add(i);
					groupMap.put(start, list);
				}
				start = start.next;
			}
		}
	}

	private static void generateLinkedListBucket(Node[] arr) {
		Node[] nodeCollection = new Node[15];
		generateNodeCollection(nodeCollection);
		// bucket 0
		arr[0] = nodeCollection[0];
		nodeCollection[0].next = nodeCollection[6];
		nodeCollection[6].next = nodeCollection[7];
		nodeCollection[7].next = nodeCollection[8];
		// bucket 1
		arr[1] = nodeCollection[1];
		nodeCollection[1].next = nodeCollection[9];
		nodeCollection[9].next = nodeCollection[7];
		// bucket 2
		arr[2] = nodeCollection[2];
		nodeCollection[2].next = nodeCollection[10];
		// bucket 3
		arr[3] = nodeCollection[3];
		nodeCollection[3].next = nodeCollection[11];
		nodeCollection[11].next = nodeCollection[12];
		// bucket 4
		arr[4] = nodeCollection[4];
		nodeCollection[4].next = nodeCollection[13];
		nodeCollection[13].next = nodeCollection[14];
		nodeCollection[14].next = nodeCollection[11];
		// bucket 5
		arr[5] = nodeCollection[5];
	}

	private static void generateNodeCollection(Node[] nodeCollection) {
		for (int i = 1; i <= nodeCollection.length; i++) {
			nodeCollection[i - 1] = new Node(i * 10);
		}
	}

}
