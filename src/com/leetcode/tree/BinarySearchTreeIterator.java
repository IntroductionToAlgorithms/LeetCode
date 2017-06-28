package com.leetcode.tree;

import com.leetcode.util.TreeNode;

import java.util.Stack;

/**
 * Created by guangoon on 6/28/17.
 */
public class BinarySearchTreeIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    public BinarySearchTreeIterator(TreeNode root) {
        stack.push(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        while(!stack.isEmpty()){
            if(stack.peek().left != null){
                TreeNode node = stack.peek();
                TreeNode left = node.left;
                node.left = null;
                stack.push(left);
            }else {
                return true;
            }
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        if(node.right != null){
            stack.push(node.right);
        }
        node.right = null;
        return node.val;
    }
}

