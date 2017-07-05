package com.leetcode.tree;

import com.leetcode.util.TreeNode;

/**
 * Created by guangoon on 7/5/17.
 */
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        flatten(root.left);
        TreeNode right = root.right;
        if(root.left != null){
            root.right = root.left;
            root.left = null;
            while(root.right != null){
                root = root.right;
            }
            root.right = right;
        }
        flatten(right);
    }
}
