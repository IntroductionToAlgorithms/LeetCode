package com.leetcode.tree;

public class InvertBinaryTree {

	public static void main(String[] args) {

	}

	public TreeNode invertTree(TreeNode root) {
		if(root == null )
			return null;
		TreeNode left = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(left);
		return root;
	}

}
