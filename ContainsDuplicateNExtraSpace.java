class Solution {
	public boolean containsDuplicate(int[] nums) {
		// if length of the array if less than 1
		// we return false
		if (nums.length <= 1) {
			return false;
		}
		// we keep a set to store seen elements
		Set < Integer > set = new HashSet < >();
		for (int i = 0; i < nums.length; i++) {
			// if an element already seen
			// return true
			if (set.contains(nums[i])) {
				return true;
			} else {
				// else add to set for future reference
				set.add(nums[i]);
			}
		}
		// return false in all other cases
		return false;
	}
}
