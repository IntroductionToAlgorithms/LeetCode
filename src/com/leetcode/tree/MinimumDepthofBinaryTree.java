package com.leetcode.tree;

import com.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by guangoon on 7/3/17.
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int minDepth = 1;
        Queue<TreeNode> q = new LinkedList<>();
        int size = 1;
        q.offer(root);

        while(size > 0){
            int index = 0;
            while(!q.isEmpty() && index < size){
                TreeNode x = q.poll();
                if(x.left == null && x.right == null)
                    return minDepth;
                if(x.left != null)
                    q.offer(x.left);
                if(x.right != null)
                    q.offer(x.right);
                index++;
            }
            minDepth++;
            size = q.size();
        }
        return minDepth;
    }
}
