package org.leetcode.medium;

public class SearchInRotatedSortedArray33 {
  public static void main(String[] args) {
    SearchInRotatedSortedArray33 s = new SearchInRotatedSortedArray33();
    System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
  }

  //not my solution. You need to write all cases of what can be and then write solution
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {

      int mid = (left + right) / 2;

      if (target == nums[mid]) {
        return mid;
      }

      if (nums[left] <= nums[mid]) {
        if (target > nums[mid] | target < nums[left]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      } else {
        if (target < nums[mid] | target > nums[right]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    }
    return -1;
  }
}
