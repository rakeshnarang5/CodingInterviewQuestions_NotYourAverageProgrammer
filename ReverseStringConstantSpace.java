class Solution {
	// very basic problem
	// time complexity -> O(n) -> linear
	// space complexity -> O(1) -> constant
	public void reverseString(char[] s) {
		int startIdx = 0;
		int endIdx = s.length - 1;
		// keep swapping
		while (startIdx < endIdx) {
			char temp = s[startIdx];
			s[startIdx] = s[endIdx];
			s[endIdx] = temp;
			startIdx++;
			endIdx--;
		}
	}
}
