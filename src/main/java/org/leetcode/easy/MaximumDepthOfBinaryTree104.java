package org.leetcode.easy;

//DFS - https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
public class MaximumDepthOfBinaryTree104 {
  public static void main(String[] args) {

  }

  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int maxLeftDepth = maxDepth(root.left) + 1;
      int maxRightDepth = maxDepth(root.right) + 1;
      return Math.max(maxLeftDepth, maxRightDepth);
    }
  }
}
