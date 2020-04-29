// time complexity -> O(n)
// space complexity -> O(n) in the worst case
class Solution {
	public int singleNumber(int[] nums) {
		// init ans with 0
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			// bitwise xor each number to ans and store result in ans
			// all duplicate numbers will xor each other and result to 0
			// only single number will xor 0 and set ans to itself
			// thus at the end, ans will have our answer
			ans ^= nums[i];
		}
		// return ans
		return ans;
	}
}
