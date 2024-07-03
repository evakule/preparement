package org.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {

  public static void main(String[] args) {
    MinimumWindowSubstring76 m = new MinimumWindowSubstring76();
    System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
  }

  //Not my solution
  public String minWindow(String s, String t) {
    if (s == null || t == null || s.isEmpty() || t.isEmpty() ||
        s.length() < t.length()) {
      return "";
    }
    int[] map = new int[128];
    int count = t.length();
    int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;

    //create chars frequency
    for (char c : t.toCharArray()) {
      map[c]++;
    }

    char[] chS = s.toCharArray();

    while (end < chS.length) {
      if (map[chS[end++]]-- > 0) {
        count--;
      }
      while (count == 0) {
        if (end - start < minLen) {
          startIndex = start;
          minLen = end - start;
        }
        if (map[chS[start++]]++ == 0) {
          count++;
        }
      }
    }

    return minLen == Integer.MAX_VALUE ? ""
        : s.substring(startIndex, startIndex + minLen);
  }
}
