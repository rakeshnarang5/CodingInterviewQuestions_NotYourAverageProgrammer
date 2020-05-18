import java.util.ArrayList;
import java.util.List;

public class ValidPalindromeLeetCode {

	public static void main(String[] args) {
		System.out.println(isPalindrome("90A man, a plan, a canal: Panama09"));
	}

	public static boolean isPalindrome(String input) {
		// first we conv string to lowercase
		input = input.toLowerCase();
		// then we remove all special characters
		input = removeAllSpecialCharacters(input);
		// then we simply check if a string is palindrome
		return isStringPalindrome(input);
	}

	// time complexity -> O(n) in the worst case
	// start with two ptr, one at 0 and one at end of input
	// keep incrementing start and decrementing end
	// keep checking for equality
	// as and when an unequal character is seen, the string is not a palindrome
	private static boolean isStringPalindrome(String input) {
		boolean isPalindrome = true;
		int start = 0;
		int end = input.length() - 1;
		while (start < end) {
			if (input.charAt(start) != input.charAt(end)) {
				isPalindrome = false;
				break;
			}
			start++;
			end--;
		}
		return isPalindrome;
	}

	// time complexity -> O(2n)
	// O(n) -> for removing special chars
	// O(n) -> for converting List<Character> to string
	private static String removeAllSpecialCharacters(String input) {
		List<Character> chars = new ArrayList<>();
		for (char oneChar : input.toCharArray()) {
			// filtering logic is on the basic of ascii code of characters
			// 'a'->'z' is accepted and '0' to '9' is accepted
			// all others are filtered out
			if ((oneChar - 'a' >= 0) && (oneChar - 'a' <= 26) || ((oneChar - 'a' >= -49) && (oneChar - 'a' <= -40))) {
				chars.add(oneChar);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char ch : chars) {
			sb.append(ch);
		}
		return sb.toString();
	}

}
