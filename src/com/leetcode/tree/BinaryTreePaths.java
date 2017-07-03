package com.leetcode.tree;

import com.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by guangoon on 7/3/17.
 */
public class BinaryTreePaths {
    private List<String> res = new LinkedList();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return res;
        String start = root.val + "";
        if(root.left == null && root.right == null){
            res.add(start);
            return res;
        }
        if(root.left != null)
            binaryTreePaths(root.left, start);
        if(root.right != null)
            binaryTreePaths(root.right, start);
        return res;
    }

    public void binaryTreePaths(TreeNode root, String inputPath){
        inputPath += "->" + root.val;
        if(root.left == null && root.right == null){
            res.add(inputPath);
            return;
        }
        if(root.left != null)
            binaryTreePaths(root.left, inputPath);
        if(root.right != null)
            binaryTreePaths(root.right, inputPath);
    }
}
