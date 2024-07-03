package org.leetcode.medium;

public class SearchA2DMatrix74 {
  public static void main(String[] args) {
    int[][] array = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 60}};

    int[][] arr2 = {{1}, {3}};

    SearchA2DMatrix74 s = new SearchA2DMatrix74();

    System.out.println(s.searchMatrix(array, 3));

  }


  public boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length;
    if (rows == 0) return false;
    int cols = matrix[0].length;

    int left = 0;
    int right = rows * cols - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      //Key difference between simple bsearch and 2d bsearch
      int midElement = matrix[mid / cols][mid % cols];

      if (midElement == target) {
        return true;
      } else if (midElement < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }

  public boolean search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {

      int mid = left + (right - left) / 2;

      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        return true;
      }
    }
    return false;
  }
}
