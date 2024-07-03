package org.leetcode.easy;


//DFS - https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree226 {
  public static void main(String[] args) {
    InvertBinaryTree226 i = new InvertBinaryTree226();
    TreeNode root1 = new TreeNode(4);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(7);
    root1.left.left = new TreeNode(1);
    root1.left.right = new TreeNode(3);
    root1.right.left = new TreeNode(6);
    root1.right.right = new TreeNode(9);

    // Test case 2: [2,1,3]
    TreeNode root2 = new TreeNode(2);
    root2.left = new TreeNode(1);
    root2.right = new TreeNode(3);

    // Test case 3: Empty tree
    TreeNode root3 = null;

    // Test case 4: Single node tree
    TreeNode root4 = new TreeNode(5);

    // Test case 5: More complex tree
    TreeNode root5 = new TreeNode(10);
    root5.left = new TreeNode(5);
    root5.right = new TreeNode(15);
    root5.left.left = new TreeNode(3);
    root5.left.right = new TreeNode(7);
    root5.right.left = new TreeNode(12);
    root5.right.right = new TreeNode(20);


    // Inverting trees
    TreeNode invertedRoot1 = i.invertTree(root1);
    TreeNode invertedRoot2 = i.invertTree(root2);
    TreeNode invertedRoot3 = i.invertTree(root3);
    TreeNode invertedRoot4 = i.invertTree(root4);
    TreeNode invertedRoot5 = i.invertTree(root5);


  }

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = root.left;
    TreeNode right = root.right;
    root.right = invertTree(left);
    root.left = invertTree(right);
    return root;

  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}