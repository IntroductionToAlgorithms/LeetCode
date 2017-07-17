package com.leetcode.tree;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by guangoon on 7/8/17.
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if(n < 1){
            return new ArrayList();
        }
        return generateTrees(1,n);
    }

    public List<TreeNode> generateTrees(int lo, int hi){
        List<TreeNode> res = new LinkedList<>();
        if(lo > hi){
            res.add(null);
            return res;
        }

        if(lo == hi){
            res.add(new TreeNode(lo));
            return res;
        }
        for(int i = lo; i <= hi; i++){
            List<TreeNode> left = generateTrees(lo, i - 1);
            List<TreeNode> right = generateTrees(i + 1, hi);

            for(TreeNode lNode : left){
                for(TreeNode rNode : right){
                    TreeNode root = new TreeNode(i);
                    root.left = lNode;
                    root.right = rNode;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
