class CountTracker {
	char character;
	int numOccurrence;
	int idx;
	public CountTracker(char character, int numOccurrence, int idx) {
		super();
		this.character = character;
		this.numOccurrence = numOccurrence;
		this.idx = idx;
	}
}

class Solution {
	public int firstUniqChar(String s) {
		Map < Character,
		CountTracker > seenMap = new LinkedHashMap < >();
		for (int i = 0; i < s.length(); i++) {
			if (seenMap.containsKey(s.charAt(i))) {
				seenMap.get(s.charAt(i)).numOccurrence++;
			} else {
				seenMap.put(s.charAt(i), new CountTracker(s.charAt(i), 1, i));
			}
		}
		for (Character ch: seenMap.keySet()) {
			if (seenMap.get(ch).numOccurrence == 1) return seenMap.get(ch).idx;
		}
		return - 1;
	}
}
