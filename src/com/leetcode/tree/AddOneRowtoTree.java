package com.leetcode.tree;

import com.leetcode.util.TreeNode;
import com.leetcode.util.Util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by guangoon on 7/1/17.
 */
public class AddOneRowtoTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int level = 1;
        int size = 1;
        while(size > 0){
            while(!q.isEmpty() && size > 0){
                TreeNode x = q.poll();
                //System.out.println("level == " + level + ", x.val == " + x.val);
                if(level + 1 == d){
                    TreeNode tmpl = x.left;
                    TreeNode tmpr = x.right;
                    x.left = new TreeNode(v);
                    x.right = new TreeNode(v);
                    x.left.left = tmpl;
                    x.right.right = tmpr;
                }else{
                    if(x.left != null)
                        q.offer(x.left);
                    if(x.right != null)
                        q.offer(x.right);
                }
                size--;
            }
            size = q.size();
            level++;
        }
        return root;
    }

    public static void main(String[] args){
        String ss = "[4,2,null,3,1]";
        TreeNode root = Util.buildTreeNode(ss);
        AddOneRowtoTree aort = new AddOneRowtoTree();
        aort.addOneRow(root, 1, 3);
        Util.printNode(root);
    }
}
