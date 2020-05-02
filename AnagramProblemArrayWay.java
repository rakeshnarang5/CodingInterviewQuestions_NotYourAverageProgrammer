class Solution {
	// n -> size of s
	// m -> size of t
	// time complexity -> linear
	// space complexity -> constant
	public boolean isAnagram(String s, String t) {
		// we will use lookup array instead of map
		int[] lookup = new int[256];
		// increment ascii value occurrences in array
		// from first string
		for (int i = 0; i < s.length(); i++) {
			lookup[s.charAt(i)]++;
		}
		// decrement ascii value occurrences in array
		// from second string
		for (int i = 0; i < t.length(); i++) {
			lookup[t.charAt(i)]--;
		}
		// iterate over the lookup
		// if any number is > 0 or < 0, then it's not anagram
		// if any number is > 0, then that means second string has that character occurence lower
		// if any number if < 0, then that means second string has that character occurence higher
		for (int i = 0; i < lookup.length; i++) {
			if (lookup[i] != 0) {
				return false;
			}
		}
		// if all elements in lookup 0, we reach here and return true
		return true;
	}
}
