class Solution {
	// worst case time complexity O(n)
	// worst case space complexity O(n)
	public void moveZeroes(int[] nums) {
		int[] arr = new int[nums.length];
		int j = 0;
		for (Integer i: nums) {
			if (i != 0) {
				arr[j] = i;
				j++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			nums[i] = arr[i];
		}
	}
}
