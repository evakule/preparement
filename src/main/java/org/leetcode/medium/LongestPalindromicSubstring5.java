package org.leetcode.medium;

//TODO
//https://leetcode.com/problems/longest-palindromic-substring/description/
public class LongestPalindromicSubstring5 {

  public static void main(String[] args) {
    System.out.println(11 / 2);
    System.out.println(new LongestPalindromicSubstring5().longestPalindrome("cbbd"));
    System.out.println(new LongestPalindromicSubstring5().longestPalindrome("abbccbba"));
    System.out.println(new LongestPalindromicSubstring5().longestPalindrome("babad"));
    System.out.println(new LongestPalindromicSubstring5().longestPalindrome("ac"));
    System.out.println(new LongestPalindromicSubstring5().longestPalindrome("aa"));

  }


  public String longestPalindrome(String s) {
    int start = 0;
    int end = 0;

    for (int i = 0; i < s.length(); i++) {
      int len1 = expandFromMid(s, i, i); // raceacar case
      int len2 = expandFromMid(s, i, i + 1); // abcdeffedcba case
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - ((len - 1) / 2);
        end = i + (len / 2);
        if (start == 0 && end == s.length() - 1) {
          return s.substring(start, end + 1);
        }
      }
    }

    return s.substring(start, end + 1);
  }

  //searching for length of potential palindrome
  public int expandFromMid(String s, int left, int right) {
    if (s == null || left > right) return 0;

    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }

    return right - left - 1;
  }


  // my bad solution N^2
//  public String longestPalindrome(String s) {
//    String longestPalindrome = String.valueOf(s.charAt(0));
//    for (int left = 0; left < s.length(); left++) {
//      int right = s.length();
//      while (left < right) {
//        String check = s.substring(left, right);
//        if (isPalindrome(check)) {
//          if (check.length() > longestPalindrome.length()) {
//            longestPalindrome = check;
//          }
//        }
//        right--;
//      }
//    }
//    return longestPalindrome;
//  }
//
//  public boolean isPalindrome(String s) {
//    int left = 0;
//    int right = s.length() - 1;
//    boolean isPalindrome = true;
//    while (left < right) {
//      if (s.charAt(left) != s.charAt(right)) {
//        return false;
//      }
//      left++;
//      right--;
//    }
//    return isPalindrome;
//  }
}
