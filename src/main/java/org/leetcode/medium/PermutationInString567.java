package org.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString567 {
  public static void main(String[] args) {
    PermutationInString567 p = new PermutationInString567();

    System.out.println(p.checkInclusion("ab", "eidbaooo"));
    System.out.println(p.checkInclusion("ab", "eidboaoo"));
    System.out.println(p.checkInclusion("adc", "dcda"));

  }

  //My solution
  public boolean checkInclusion(String s1, String s2) {
    int leftP = 0;
    int rightP = s1.length();
    Map<Character, Integer> check = getMap(s1);

    while (rightP < s2.length() + 1) {
      String word = s2.substring(leftP, rightP);
      if (areAnagrams(check, word)) {
        return true;
      }
      leftP++;
      rightP++;
    }
    return false;
  }

  private boolean areAnagrams(Map<Character, Integer> check, String word) {
    return check.equals(getMap(word));
  }

  private Map<Character, Integer> getMap(String s) {
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    return map;
  }



}
