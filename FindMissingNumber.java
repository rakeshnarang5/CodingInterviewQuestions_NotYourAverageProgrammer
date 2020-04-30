public class Main {
	/*
    * find the missing number in an array
    * given an array of size n, containing 1 to n elements
    * one element is missing
    * find the missing element
    * elements won't repeat and missing element is represented by 0
    */
	public static void main(String[] args) {
		// missing element is 8
		int[] arr = new int[] {
			10,
			0,
			6,
			4,
			2,
			1,
			3,
			5,
			7,
			9
		};
		int result = findMissingElement(arr);
		System.out.println(result);
	}

	// time complexity -> linear
	// space complexity -> constant
	private static int findMissingElement(int[] arr) {
		int expectedSum = 0;
		int actualSum = 0;
		// calculate expected sum
		for (int i = 1; i <= arr.length; i++) {
			expectedSum += i;
		}
		// calculate actual sum
		for (Integer i: arr) {
			actualSum += i;
		}
		// difference of actualSum and expectedSum will be result
		return expectedSum - actualSum;
	}
}
