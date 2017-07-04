package com.leetcode.tree;

import com.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by guangoon on 7/4/17.
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null)
            return res;
        int size = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(size > 0){
            int index = 0;
            List<Integer> tmpRes = new LinkedList<>();
            while(!q.isEmpty() && index < size){
                TreeNode x = q.poll();
                tmpRes.add(x.val);
                if(x.left != null)
                    q.offer(x.left);
                if(x.right != null)
                    q.offer(x.right);
                index++;
            }
            res.add(0,tmpRes);
            size = q.size();
        }
        return res;
    }
}
