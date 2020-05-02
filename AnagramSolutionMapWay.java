class Solution {
	// n -> size of s
	// m -> size of t
	// time complexity -> O(n) + O(t) -> linear
	// space complexity -> O(n) -> for the lookup map
	public boolean isAnagram(String s, String t) {
		// we have a lookup map
		Map < Character,
		Integer > lookupMap = new HashMap < >();
		// store frequence of characters of s in the map
		for (int i = 0; i < s.length(); i++) {
			if (lookupMap.containsKey(s.charAt(i))) {
				int count = lookupMap.get(s.charAt(i));
				lookupMap.put(s.charAt(i), count + 1);
			} else {
				lookupMap.put(s.charAt(i), 1);
			}
		}
		// keep remove character seen in t from lookup map
		// e.g. if map has a -> 3
		// then if one a is seen in t, make a->2 in map
		// then if another a seen, make a-1 in map
		// the if third a is seen, the remove a from map
		for (int i = 0; i < t.length(); i++) {
			if (lookupMap.containsKey(t.charAt(i))) {
				int count = lookupMap.get(t.charAt(i));
				count--;
				if (count > 0) {
					lookupMap.put(t.charAt(i), count);
				} else {
					lookupMap.remove(t.charAt(i));
				}
			} else {
				// if you find a character in t that is not present in map
				// return false then and there
				return false;
			}
		}
		// if all elements from map removed, return true
		if (lookupMap.size() == 0) {
			return true;
		}
		// return false in all other cases
		return false;
	}
}
