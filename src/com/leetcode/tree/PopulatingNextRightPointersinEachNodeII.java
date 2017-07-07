package com.leetcode.tree;

import com.leetcode.util.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by guangoon on 7/7/17.
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);
        int size = 1;
        while(size > 0){
            int index = 0;
            TreeLinkNode prev = null;
            while(!q.isEmpty() && index < size){
                TreeLinkNode x = q.poll();
                if(x.left != null){
                    q.offer(x.left);
                }

                if(x.right != null){
                    q.offer(x.right);
                }
                if(prev == null){
                    prev = x;
                }else{
                    prev.next = x;
                    prev = x;
                }
                index++;
            }
            size = q.size();
        }
    }
}
