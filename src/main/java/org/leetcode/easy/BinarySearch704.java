package org.leetcode.easy;

public class BinarySearch704 {
  public static void main(String[] args) {
    BinarySearch704 b = new BinarySearch704();

    System.out.println(b.search(new int[]{-1, 0, 3, 5, 9, 12}, 9)); // 4
    System.out.println(b.search(new int[]{-1, 0, 3, 5, 9, 12}, 2)); // -1

  }

  public int search(int[] nums, int target) {
    if (nums[0] == target) return 0;
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {

//      int mid = (left + right) / 2; - right case but when (right + left) > Integer.MAX_VALUE we will stop.
      int mid = left + (right - left) / 2;

      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        return mid;
      }
    }

    return -1;

  }
}
