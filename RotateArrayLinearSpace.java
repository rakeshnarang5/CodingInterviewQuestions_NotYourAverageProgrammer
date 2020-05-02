class Solution {
	// time complexity -> O(n) -> linear
	// space complexity -> O(n) -> linear
	public void rotate(int[] nums, int k) {
		// if length of array is 0 or 1, no rotation
		if (nums.length == 0 || nums.length == 1) {
			return;
		}
		// we take mod of k steps
		// let's say if k is 3, and nums.length is 2, then
		// [1,2] -> [2,1] -> [1,2] -> [2,1]
		// k=3 is equal to k%nums.length i.e. 3%2=1
		k = k % nums.length;
		// we declare a result array
		int[] result = new int[nums.length];
		int j = 0;
		// copy last k elements
		for (int i = nums.length - k; i < nums.length; i++) {
			result[j] = nums[i];
			j++;
		}
		// copy remaining elements
		for (int i = 0; i < nums.length - k; i++) {
			result[j] = nums[i];
			j++;
		}
		// set in origin nums array
		for (int i = 0; i < nums.length; i++) {
			nums[i] = result[i];
		}
	}
}
