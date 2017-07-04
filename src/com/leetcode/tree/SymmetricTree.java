package com.leetcode.tree;

import com.leetcode.util.TreeNode;

/**
 * Created by guangoon on 7/4/17.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetric(root.left , root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){

        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val != right.val)
            return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
