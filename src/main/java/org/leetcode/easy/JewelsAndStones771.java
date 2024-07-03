package org.leetcode.easy;


import java.util.Set;
import java.util.stream.Collectors;


//https://leetcode.com/problems/jewels-and-stones/description/
public class JewelsAndStones771 {
  public static void main(String[] args) {
    System.out.println(numJewelsInStones("zA", "acZadsAAAzz"));
  }

  public static int numJewelsInStones(String jewels, String stones) {
    Set<Character> jewelSet = jewels.chars()
        .mapToObj(c -> (char) c).collect(Collectors.toSet());
    int counter = 0;
    for (int i = 0; i < stones.length(); i++) {
      char stone = stones.charAt(i);
      if (jewelSet.contains(stone)) {
        counter++;
      }
    }
    return counter;
  }
}
