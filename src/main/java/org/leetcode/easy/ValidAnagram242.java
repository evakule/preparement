package org.leetcode.easy;

public class ValidAnagram242 {
  public static void main(String[] args) {

    ValidAnagram242 v = new ValidAnagram242();
    System.out.println(v.isAnagram("rat", "car"));
    System.out.println(v.isAnagram("anagram", "nagaram"));

  }

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    char[] c = new char[128];
    for (int i = 0; i < s.length(); i++) {
      c[s.charAt(i)]++;
      c[t.charAt(i)]--;
    }
    for (char value : c) {
      if (value != 0) return false;
    }

    return true;
  }


}
