package com.airtelbank.upiswitch;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		printAllPalindromes("aaaaaaaaaaaaaa");
		printAllPalindromes("abcdcbaaaaaaaaaaaaabcddcba");

	}
	
	public static void printAllPalindromes(String s) {
		for(int i = 1 ; i < s.length() ; i++) {
			// check for odd palindrome
			int leftIdx = i-1;
			int rightIdx = i+1;
			boolean isAPalindrome = true;
			while(leftIdx >= 0 && rightIdx < s.length()) {
				if(s.charAt(leftIdx) != s.charAt(rightIdx)) {
					isAPalindrome=false;
					break;
				}else {
					leftIdx--;
					rightIdx++;
				}
			}
			if(isAPalindrome) {
				System.out.println(s.substring(leftIdx+1, rightIdx));
			}
			// check for even palindrome
			if(i < s.length()-1 && s.charAt(i) == s.charAt(i+1)) {
				leftIdx=i-1;
				rightIdx=i+2;
				isAPalindrome = true;
				while(leftIdx >= 0 && rightIdx < s.length()) {
					if(s.charAt(leftIdx) != s.charAt(rightIdx)) {
						isAPalindrome=false;
						break;
					}else {
						leftIdx--;
						rightIdx++;
					}
				}
				if(isAPalindrome) {
					System.out.println(s.substring(leftIdx+1, rightIdx));
				}
			}
		}
	}

}
