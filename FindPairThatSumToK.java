import java.util.HashMap;
import java.util.Map;

/*
 * in this coding problem we will find a pair of numbers in an array that sum to a given number k
 * the given statement here is that each test case will have only one such pair
 * this is an easy question that might be asked to you if you are a fresher level coder
 */
public class FindPairThatSumToK {

	public static void main(String[] args) {

		int[] tc1 = findPairThatSumToK(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 }, 30);
		System.out.println("VALIDATING TEST CASE 1");
		System.out.println(validateTestCaseInput(tc1, 0, 1));

		int[] tc2 = findPairThatSumToK(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 }, 40);
		System.out.println("VALIDATING TEST CASE 2");
		System.out.println(validateTestCaseInput(tc2, 0, 2));

		int[] tc3 = findPairThatSumToK(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 }, 190);
		System.out.println("VALIDATING TEST CASE 3");
		System.out.println(validateTestCaseInput(tc3, 8, 9));

		int[] tc4 = findPairThatSumToK(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 }, 180);
		System.out.println("VALIDATING TEST CASE 4");
		System.out.println(validateTestCaseInput(tc4, 7, 9));

	}

	/*
	 * with this method we will first convert input array to a map where key will be
	 * [value at index of input] and value will be index once our refMap is
	 * prepared, we will then iterate over input and check whether a k-input[index]
	 * is present time complexity for map conv -> O(n) time complexity of lookups,
	 * in the worst case is also O(n) because amortised lookup complexity of a
	 * hashmap is O(1) so total time complexity of this method is -> O(2n)
	 */
	private static int[] findPairThatSumToK(int[] input, int k) {
		int[] result = new int[2];
		Map<Integer, Integer> refMap = new HashMap<>();
		for (int i = 0; i < input.length; i++)
			refMap.put(input[i], i);
		for (int i = 0; i < input.length; i++) {
			if (refMap.containsKey(k - input[i])) {
				result[0] = i;
				result[1] = refMap.get(k - input[i]);
				break;
			}
		}
		return result;
	}

	/*
	 * this is a helper method that will validate whether our code is producing
	 * correct result
	 */
	private static boolean validateTestCaseInput(int[] tcOutput, int idx0Value, int idx1Value) {
		if (tcOutput[0] == 0 && tcOutput[1] == 0) {
			throw new RuntimeException("INVALID TEST CASE");
		}
		return tcOutput[0] == idx0Value && tcOutput[1] == idx1Value;
	}

}
