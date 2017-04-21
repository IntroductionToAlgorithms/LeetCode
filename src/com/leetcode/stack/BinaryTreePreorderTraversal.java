package com.leetcode.stack;

import com.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by guangoon on 17-4-21.
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if(root == null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return result;
    }
}
