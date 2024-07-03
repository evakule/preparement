package org.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate217 {
  public static void main(String[] args) {

    ContainsDuplicate217 c = new ContainsDuplicate217();
    System.out.println(c.containsDuplicate(new int[]{1, 2, 3}));
  }


  //Solution 3 (Best)
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num)) return true;
      else set.add(num);
    }
    return false;
  }


  //Solution 2
//  public boolean containsDuplicate(int[] nums) {
//    HashMap<Integer, Integer> map = new HashMap<>();
//    for (int num : nums) {
//      if (map.get(num) == null) map.put(num, 1);
//      else return true;
//    }
//    return false;
//  }

  //Solution 1
//  public boolean containsDuplicate(int[] nums) {
//    Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
//    return set.size() != nums.length;
//  }
}
