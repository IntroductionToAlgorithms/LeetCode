package com.leetcode.stack;

import com.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by guangoon on 17-4-24.
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int size = 1;
        while(size > 0){
            List<Integer> res = new LinkedList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                res.add(node.val);

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(res);
            size = queue.size();
        }
        return result;
    }
}
