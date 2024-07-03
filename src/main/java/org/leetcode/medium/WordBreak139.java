package org.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

//TODO
public class WordBreak139 {
  public static void main(String[] args) {
    WordBreak139 w = new WordBreak139();
//    System.out.println(w.wordBreak("cars", Arrays.asList("car", "ca", "rs")));
    System.out.println(w.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
//    System.out.println(w.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    System.out.println(w.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
    System.out.println(w.wordBreak("aaaaaaaa", Arrays.asList("aaaa","aaa","aa")));
    System.out.println(w.wordBreak("goalspecial", Arrays.asList("go","goal","goals","special")));

  }

  public boolean wordBreak(String s, List<String> wordDict) {
    return false;
  }
}
