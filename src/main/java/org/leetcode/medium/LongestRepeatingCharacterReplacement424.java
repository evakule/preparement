package org.leetcode.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement424 {
  public static void main(String[] args) {
    LongestRepeatingCharacterReplacement424 l = new LongestRepeatingCharacterReplacement424();
    System.out.println(l.characterReplacement("ABAB", 2));
    System.out.println(l.characterReplacement("AABABBA", 1));
//    System.out.println(l.characterReplacement("ABABAAABBBAB", 3));
//    System.out.println(l.characterReplacement("AAAA", 2));
  }

  public int characterReplacement(String s, int k) {
    if (s.length() == 1) return 1;
    Map<Character, Integer> map = new HashMap<>();
    int start = 0;
    int maxFrequency = 0;
    int maxLength = 0;

    for (int end = 0; end < s.length(); end++) {
      char c = s.charAt(end);
      map.put(c, map.getOrDefault(c, 0) + 1);
      maxFrequency = Math.max(maxFrequency, map.get(c));

      while (end - start + 1 - maxFrequency > k) {
        char leftChar = s.charAt(start);
        map.put(leftChar, map.get(leftChar) - 1);
        start++;
      }
      maxLength = Math.max(maxLength, end - start + 1);
    }

    return maxLength;
  }



}
