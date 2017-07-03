package com.leetcode.tree;

import com.leetcode.util.TreeNode;

/**
 * Created by guangoon on 7/3/17.
 */
public class SumofLeftLeaves {
    private int num = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root, false);
        return num;
    }

    public void dfs(TreeNode root, boolean isLeft){
        if(root.left == null && root.right == null){
            if(isLeft)
                num += root.val;
            return;
        }

        if(root.left != null){
            dfs(root.left, true);
        }
        if(root.right != null) {
            dfs(root.right, false);
        }
    }
}
