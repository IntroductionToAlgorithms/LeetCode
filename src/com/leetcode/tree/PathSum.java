package com.leetcode.tree;

import com.leetcode.util.TreeNode;

/**
 * Created by guangoon on 6/28/17.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    private boolean dfs(TreeNode root, int sum){
        if(root == null && sum == 0)
            return true;
        if(root == null && sum > 0)
            return false;
        if(root.val > sum)
            return false;
        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
    }
}
