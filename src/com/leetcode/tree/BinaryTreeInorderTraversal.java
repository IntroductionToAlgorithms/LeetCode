package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by guangoon on 6/28/17.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if(root == null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = null;
            node.right = null;
            if(null != right)
                stack.push(right);
            if(left == null && right == null){
                result.add(node.val);
            }
            else{
                stack.push(node);
            }
            if(null != left)
                stack.push(left);
        }
        return result;
    }
}
