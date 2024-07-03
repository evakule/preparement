package org.leetcode.easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FirstUniqueCharacterInAString387 {
  public static void main(String[] args) {

  }

  public int firstUniqChar(String s) {

    Queue<Character> q = new LinkedList<>();
    Set<Character> set = new HashSet<>();

    for (char c : s.toCharArray()) {
      if (q.contains(c)) {
        q.remove(c);
        set.add(c);
      } else {
        if (!set.contains(c)) {
          q.add(c);
        }
      }
    }
    if (!q.isEmpty()) {
      char search = q.poll();
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == search) {
          return i;
        }
      }
    }
    return -1;
  }

}
