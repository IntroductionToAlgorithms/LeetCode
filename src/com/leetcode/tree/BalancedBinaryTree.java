package com.leetcode.tree;

import com.leetcode.util.TreeNode;

/**
 * Created by guangoon on 6/30/17.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(l - r) <= 1;

    }

    private int getHeight(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
