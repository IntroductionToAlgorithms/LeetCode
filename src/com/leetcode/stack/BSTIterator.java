package com.leetcode.stack;

import com.leetcode.util.TreeNode;

import java.util.Stack;

/**
 * Created by guangoon on 17-4-23.
 */
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        if(root != null)
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
            }else{
                return true;
            }
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        if(node.right != null){
            TreeNode right = node.right;
            node.right = null;
            stack.push(right);
        }
        return node.val;
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(1);
        BSTIterator bst = new BSTIterator(node);
        while(bst.hasNext()){
            System.out.println(bst.next());
        }
    }
}

