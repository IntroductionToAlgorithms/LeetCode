package com.leetcode.tree;

import com.leetcode.util.TreeNode;

/**
 * Created by guangoon on 7/3/17.
 */
public class BinaryTreeTilt {
    private int num = 0;
    public int findTilt(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root);
        return num;
    }

    public int dfs(TreeNode root) {
        if(root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        num += Math.abs(left - right);
        return left + right + root.val;
    }
}
