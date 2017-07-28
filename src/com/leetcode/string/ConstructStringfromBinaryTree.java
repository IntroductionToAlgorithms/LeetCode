package com.leetcode.string;

import com.leetcode.util.TreeNode;

/**
 * Created by guangoon on 7/28/17.
 */
public class ConstructStringfromBinaryTree {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if(t == null)
            return "";
        dfs(t, sb);
        return sb.toString();
    }

    private void dfs(TreeNode t, StringBuilder sb){
        if(t == null)
            return;
        sb.append(t.val);
        if(t.left == null && t.right == null)
            return;
        sb.append("(");
        dfs(t.left, sb);
        sb.append(")");
        if(t.right != null) {
            sb.append("(");
            dfs(t.right, sb);
            sb.append(")");
        }
    }
}
