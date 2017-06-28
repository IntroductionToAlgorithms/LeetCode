package com.leetcode.tree;

import com.leetcode.util.TreeNode;

/**
 * Created by guangoon on 6/27/17.
 */
public class FindBottomLeftTreeValue {
    private int mMaxL = -1;
    private int mMaxLV = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return mMaxLV;
    }

    private void dfs(TreeNode x, int l){
        if(x != null){
            if(l > mMaxL) {
                mMaxL = l;
                mMaxLV = x.val;
            }
            dfs(x.left, l + 1);
            dfs(x.right, l + 1);
        }
    }
}
