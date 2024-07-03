package org.leetcode.medium;

import java.util.*;

public class GroupAnagrams49 {
  public static void main(String[] args) {
    String[] s = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
    GroupAnagrams49 g = new GroupAnagrams49();
    g.groupAnagrams(s).forEach(System.out::println);

  }

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String word : strs) {
      String anagramKey = getKey(word);
      List<String> list = map.get(anagramKey);
      if (list == null) {
        list = new ArrayList<>();
      }
      list.add(word);
      map.put(anagramKey, list);
    }
    return new ArrayList<>(map.values());
  }

  public String getKey(String s) {
    char[] charArray = s.toCharArray();
    Arrays.sort(charArray);
    return new String(charArray);
  }
}
