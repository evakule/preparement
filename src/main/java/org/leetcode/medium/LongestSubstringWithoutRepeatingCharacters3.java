package org.leetcode.medium;

public class LongestSubstringWithoutRepeatingCharacters3 {
  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharacters3 l = new LongestSubstringWithoutRepeatingCharacters3();
    System.out.println(l.lengthOfLongestSubstring("abcabcbb"));

  }

  public int lengthOfLongestSubstring(String s) {
    int[] chars = new int[128];
    int maxLength = 0;

    int left = 0;
    int right = 0;

    while (right < s.length()) {
      char c = s.charAt(right);
      chars[c]++;

      while (chars[c] > 1) {
        char leftChar = s.charAt(left);
        chars[leftChar]--;
        left++;
      }
      right++;
      maxLength = Math.max(maxLength, right - left);
    }
    return maxLength;
  }
}
