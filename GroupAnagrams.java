import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		// result is our return value
		List<List<String>> result = new ArrayList<>();
		// we will take a reference map to store grouped anagrams together
		// key will be sorted representation of a string
		// all anagrams have same sorted rep, for e.g. tan and nat both have ant as
		// their sorted rep
		Map<String, List<String>> refMap = new HashMap<>();
		// if input is empty, we don't process
		if (strs.length > 0) {
			// let's loop over string array one by one
			for (String str : strs) {
				// conv string to char array -> O(K) complexity
				char[] strCharArray = str.toCharArray();
				// sort charArray O(KlogK) complexity
				Arrays.sort(strCharArray);
				// conv sortedCharrayArray back to string
				String sorted = new String(strCharArray);
				// init a new list by null
				List<String> list = null;
				// if map already has that sorted string, get that list
				if (refMap.containsKey(sorted)) {
					list = refMap.get(sorted);
				} else {
					// else init a new list
					list = new ArrayList<>();
				}
				// add current str to list
				list.add(str);
				// put the new list back to map
				refMap.put(sorted, list);
			}
		}
		// add all collected groups of anagrams to result
		result.addAll(refMap.values());
		// and return the result
		return result;
	}

}
