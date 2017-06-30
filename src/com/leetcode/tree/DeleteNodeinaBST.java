package com.leetcode.tree;

import com.leetcode.util.TreeNode;
import com.leetcode.util.Util;

import java.util.Arrays;

/**
 * Created by guangoon on 6/27/17.
 */
public class DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if (root.right == null) return root.left;
            if (root.left  == null) return root.right;
            TreeNode tmpNode = root;
            root = min(tmpNode.right);

            root.right = deleteMin(tmpNode.right);
            root.left = tmpNode.left;
        }
        return root;
    }

    private TreeNode min(TreeNode x){
        if(x.left == null)
            return x;
        return min(x.left);
    }

    private TreeNode deleteMin(TreeNode x){
        if(x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    public static void main(String[] args){
        String ss = "[5,3,6,2,4,null,7]";
        TreeNode root = Util.buildTreeNode(ss);
        DeleteNodeinaBST dnb = new DeleteNodeinaBST();
        dnb.printNode(root);
        dnb.deleteNode(root,3);
        dnb.printNode(root);
    }

    private void printNode(TreeNode x){
        if(x == null)
            return;
        System.out.print(x.val);
        printNode(x.left);
        printNode(x.right);
    }
}
