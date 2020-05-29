
public class LongestCommonPrefix {

	public static void main(String[] args) {

		String[] strings = new String[] { "flower", "flow", "flight" };
		System.out.println(findLongestCommonPrefix(strings));
		System.out.println(findLongestCommonPrefix(new String[] {"c","c"}));

	}

	private static String findLongestCommonPrefix(String[] strs) {
		if(strs.length==0 || strs[0].length() == 0) {
			return "";
		}
		if(strs.length==1) {
			return strs[0];
		}
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		char currChar = '\0';
		boolean commonFound = false;
		int smallest = Integer.MAX_VALUE;
		for(String str:strs) {
			if(str.length() < smallest) {
				smallest=str.length();
			}
		}
		while (!commonFound && idx < smallest) {
			for (int i = 0; i < strs.length; i++) {
				if (i == 0) {
					currChar = strs[i].charAt(idx);
				} else if (currChar != strs[i].charAt(idx)) {
					commonFound=true;
				} else {
					if (i == strs.length - 1) {
						idx++;
						sb.append(currChar);
					}
				}
			}
		}
		return sb.toString();
	}

}
