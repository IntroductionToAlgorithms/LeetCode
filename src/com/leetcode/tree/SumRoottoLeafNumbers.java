package com.leetcode.tree;

import com.leetcode.util.TreeNode;

/**
 * Created by guangoon on 7/5/17.
 */
public class SumRoottoLeafNumbers {
    private int m_sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, m_sum);
        return m_sum;
    }

    private void dfs(TreeNode x, int sum){
        if(x == null)
            return;
        if(x.left == null && x.right == null){
            m_sum += sum * 10 + x.val;
            return;
        }
        sum = sum * 10 +  x.val;
        dfs(x.left,sum);
        dfs(x.right, sum);
    }
}
