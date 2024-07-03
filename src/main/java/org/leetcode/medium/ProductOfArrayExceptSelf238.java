package org.leetcode.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf238 {
  public static void main(String[] args) {
    ProductOfArrayExceptSelf238 p = new ProductOfArrayExceptSelf238();
    int[] ints = p.productExceptSelf(new int[]{1, 2, 3, 4});
    Arrays.stream(ints).sequential().forEach(System.out::println);
  }

  public int[] productExceptSelf(int[] nums) {
    int[] left = new int[nums.length];
    int[] right = new int[nums.length];
    int[] resultArray = new int[nums.length];

    left[0] = 1;
    right[nums.length - 1] = 1;

    for (int i = 1; i < nums.length; i++) {
      left[i] = nums[i - 1] * left[i - 1];
    }

    for (int i = nums.length - 2; i > -1; i--) {
      right[i] = nums[i + 1] * right[i + 1];
    }

    for (int i = 0; i < nums.length; i++) {
      resultArray[i] = left[i] * right[i];
    }

    return resultArray;
  }

}
