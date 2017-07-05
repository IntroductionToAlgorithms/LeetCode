package com.leetcode.tree;

import com.leetcode.util.TreeNode;

/**
 * Created by guangoon on 7/5/17.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(null, root, null);
    }

    public boolean isValidBST(TreeNode min, TreeNode root, TreeNode max){
        if(root == null)
            return true;
        if(min != null && root.val <= min.val)
            return false;
        if(max != null && root.val >= max.val)
            return false;
        return isValidBST(min, root.left, root) && isValidBST(root,root.right,max);
    }
}
