package com.leetcode.tree;

import com.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by guangoon on 6/28/17.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int size = 1;
        boolean order = true;
        while(size > 0){
            List<Integer> res = new LinkedList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                System.out.println("node value == " + node.val);
                System.out.println("order value == " + order);
                if(order){
                    res.add(node.val);
                }else{
                    res.add(0,node.val);
                }

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(res);
            size = queue.size();
            order = !order;
        }
        return result;
    }
}
