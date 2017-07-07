package com.leetcode.tree;

import com.leetcode.util.TreeNode;

import java.util.Stack;

/**
 * Created by guangoon on 7/7/17.
 */
public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        int index = 0;
        Stack<TreeNode> x = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !x.isEmpty()){
            while(cur != null){
                x.push(cur);
                cur = cur.left;
            }

            cur = x.pop();
            if(++index == k){
                return cur.val;
            }
            cur = cur.right;
        }
        return index;
    }
}
