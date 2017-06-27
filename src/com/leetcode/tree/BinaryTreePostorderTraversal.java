package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by guangoon on 6/28/17.
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
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
            if(left == null && right == null){
                result.add(node.val);
            }
            else{
                stack.push(node);
            }
            if(null != right)
                stack.push(right);
            if(null != left)
                stack.push(left);
        }
        return result;
    }

}
