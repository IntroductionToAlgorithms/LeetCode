package com.leetcode.tree;

import com.leetcode.util.TreeNode;

/**
 * Created by guangoon on 7/6/17.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        int n1 =  dfs(root,false);
        int n2 = dfs(root,true);
        return Math.max(n1,n2);
    }

    public int dfs(TreeNode root, boolean choose){
        if(root == null)
            return 0;
        if(!choose){
          int n1 = dfs(root.left, true);
          int n2 = dfs(root.right, true);
          int n3 = dfs(root.left, false);
          int n4 = dfs(root.right, false);
          return Math.max(Math.max(n1 + n1,n3 + n4),Math.max(n1 + n3, n2 + n4)) + root.val;
        }
        else{
         int n5 = dfs(root.left, false);
         int n6 = dfs(root.right, false);
         return n5 + n6 + root.val;
        }
    }
}
