/*
* we will use a count tracker class to store characters, it's occurrences and the last idx
*/
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
	/*
    * we will take a linked hashmap -> store custom object for character in the hashmap -> if char is new, count will be new -> else count will be incremented -> at last, we will will check all the characters in the map and for the character where the count is 1, we will return the idx of that character -> else we will return -1
    */
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
