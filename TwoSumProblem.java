class Solution {
	// time complexity -> O(n) -> linear
	// space complexity -> O(n) -> linear
	public int[] twoSum(int[] nums, int target) {
		// define an array to fill with result
		int[] ans = new int[2];
		// we will use a hashmap to store seen values and their idx
		// val-idx map = val is key, idx in value
		Map < Integer,
		Integer > valIdxMap = new HashMap < >();
		// iterate once
		for (int i = 0; i < nums.length; i++) {
			// if map contains target - number, then we have found our result
			// e.g. target is 9, number is 11, then, if we have seen -2 earlier
			// we have hit our result
			if (valIdxMap.containsKey(target - nums[i])) {
				// once we find result
				// we will set map number at idx-0
				// current number at idx-1
				// and break the loop
				ans[0] = valIdxMap.get(target - nums[i]);
				ans[1] = i;
				break;
			} else {
				// else we will just add the number to our seen map
				valIdxMap.put(nums[i], i);
			}
		}
		// we return the result
		return ans;
	}
}
