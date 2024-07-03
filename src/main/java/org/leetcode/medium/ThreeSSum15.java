package org.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/3sum/description/
public class ThreeSSum15 {
  public static void main(String[] args) {
    ThreeSSum15 t = new ThreeSSum15();

    t.threeSum(new int[]{-1, 0, 1, 2, -1, -4}).forEach(System.out::println);

  }

  //My solution (N^2)
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums.length < 3) return new ArrayList<>();

    Arrays.sort(nums);

    HashSet<List<Integer>> result = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left++;
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }

    }

    return result.stream().toList();
  }
}
