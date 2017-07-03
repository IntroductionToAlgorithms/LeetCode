package com.leetcode.tree;

import com.leetcode.util.TreeNode;

/**
 * Created by guangoon on 7/3/17.
 */
public class PathSumIII {
    private int m_Num = 0;
    private int m_Sum = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return m_Num;
        m_Sum = sum;
        paths(root);
        return m_Num;
    }

    private void paths(TreeNode root){
        if(root == null)
            return;
        pathSum2(root, m_Sum);
        paths(root.left);
        paths(root.right);
    }

    public void pathSum2(TreeNode root, int sum){
        if(root.val == sum){
            m_Num++;
        }
        sum -=root.val;
        if(root.left != null) {
            pathSum2(root.left, sum);
        }
        if(root.right != null) {
            pathSum2(root.right, sum);
        }
    }
}
