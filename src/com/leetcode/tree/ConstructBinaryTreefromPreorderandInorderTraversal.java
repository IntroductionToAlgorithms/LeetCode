package com.leetcode.tree;

import com.leetcode.util.TreeNode;

/**
 * Created by guangoon on 7/5/17.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if(pstart > pend || istart > iend)
            return null;
        int pos = -1;
        for(int i = istart; i <= iend; i++){
            if(inorder[i] == preorder[pstart]){
                pos = i;
                break;
            }
        }

        TreeNode root = new TreeNode(preorder[pstart]);
        root.left = buildTree(preorder, pstart + 1, pstart + pos - istart, inorder, istart, pos -1);
        root.right = buildTree(preorder, pend - iend + pos + 1, pend, inorder, pos + 1, iend);
        return root;
    }
}
