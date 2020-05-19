public class FirstUniqueChar {

	public static void main(String[] args) {
		System.out.println(findUniqueChar("aadadaad"));
	}

	/*
	 * we will iterate from idx 0 to idx n-1 if first occurrence and last occurrence
	 * of a character is same then that character is unique in the string
	 */
	private static int findUniqueChar(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
				return i;
		}
		return -1;
	}

}
