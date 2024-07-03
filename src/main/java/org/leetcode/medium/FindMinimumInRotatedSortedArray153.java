package org.leetcode.medium;

public class FindMinimumInRotatedSortedArray153 {
  public static void main(String[] args) {
    FindMinimumInRotatedSortedArray153 f = new FindMinimumInRotatedSortedArray153();

    System.out.println(f.findMin(new int[]{3, 4, 5, 1, 2}));
  }


  public int findMin(int[] nums) {
    int result = nums[0];
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      if (nums[left] < nums[right]) {
        return Math.min(result, nums[left]);
      }

      int mid = (left + right) / 2;
      result = Math.min(result, nums[mid]);

      if (nums[left] <= nums[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return result;
  }
}
