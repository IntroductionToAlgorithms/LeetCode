package com.leetcode.tree;

import com.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by guangoon on 7/4/17.
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        int size = 1;
        q.offer(root);
        while(size > 0){
            int index = 0;
            while(!q.isEmpty() && index < size){
                TreeNode x = q.poll();
                if(x.left != null)
                    q.offer(x.left);
                if(x.right != null)
                    q.offer(x.right);
                index++;
                if(index + 1 == size){
                    res.add(x.val);
                }
            }
            size = q.size();
        }
        return  res;
    }
}
