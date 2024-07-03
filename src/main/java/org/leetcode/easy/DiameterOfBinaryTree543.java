package org.leetcode.easy;

public class DiameterOfBinaryTree543 {

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(4);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(7);

    root1.left.left = new TreeNode(1);
    root1.left.right = new TreeNode(3);

    root1.right.left = new TreeNode(6);
    root1.right.right = new TreeNode(9);

    DiameterOfBinaryTree543 d = new DiameterOfBinaryTree543();
    System.out.println(d.diameterOfBinaryTree(root1));
  }

  private int diameter;

  public int diameterOfBinaryTree(TreeNode root) {
    diameter = 0;
    calculateDepth(root);
    return diameter;
  }

  private int calculateDepth(TreeNode node) {
    if (node == null) {
      return 0;
    }

    //Firstly you go through all nodes till the end and then you calculating diameter var (Postfix visit)
    int left = calculateDepth(node.left);
    int right = calculateDepth(node.right);

    diameter = Math.max(diameter, left + right);

    return Math.max(left, right) + 1;
  }
}
