class Solution {
	// time complexity -> O(n) -> linear
	// space complexity -> O(1) -> constant
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
		// reverse whole arr
		reverse(nums, 0, nums.length - 1);
		// reverse first k elements
		reverse(nums, 0, k - 1);
		// reverse again from k, till end of array
		reverse(nums, k, nums.length - 1);
	}

	// code to reverse an array from startIdx to endIdx
	public void reverse(int[] nums, int startIdx, int endIdx) {
		while (startIdx < endIdx) {
			int temp = nums[startIdx];
			nums[startIdx] = nums[endIdx];
			nums[endIdx] = temp;
			startIdx++;
			endIdx--;
		}
	}
}
