class Solution {
	// time complexity O(n)
	// space complexity -> no extra space
	public void moveZeroes(int[] nums) {
		// take two pts i and j and start with idx 0
		int i = 0;
		int j = 0;
		// run one loop till j becomes nums.length - 1
		while (j < nums.length) {
			// if i and j are not equal, enter this if
			if (i != j) {
				// if j-idx is not zero
				// replace with i-idx which would be zero
				if (nums[j] != 0) {
					// replace
					nums[i] = nums[j];
					// increase i
					i++;
					// set j-idx to zero
					nums[j] = 0;
				}
				// if i-idx and j-idx are same
				// check whether i-idx is zero
				// if it is not zero, increment both i-ptr and j-ptr
			}
			if (nums[i] != 0) {
				i++;
				j++;
				// else, increment only j-ptr and wait for replace code block to hit
				// in next iteration
			} else {
				j++;
			}
		}
	}
}
