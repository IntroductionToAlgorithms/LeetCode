package com.leetcode.tree;

/**
 * Created by guangoon on 6/28/17.
 */
public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null)
            return false;
        if(isSameTree(s, t))
            return true;
        return isSubtree(s.left, t) || isSubtree(s.right,t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t){
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        if(s.val != t.val)
            return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
