package com.leetcode.tree;

import com.leetcode.util.TreeNode;
import com.leetcode.util.Util;

/**
 * Created by guangoon on 7/4/17.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder,int istart, int iend, int[] postorder,int pstart, int pend ) {
        System.out.println("istart == " + istart + ", iend == " + iend + ", pstart == " + pstart + ", pend == " + pend);
        if(istart > iend || pstart > pend )
            return null;
        TreeNode root = new TreeNode(postorder[pend]);
        int pos = -1;
        for(int i = istart; i <= iend; i++){
            if(inorder[i] == postorder[pend]) {
                pos = i;
                break;
            }
        }

        root.left = buildTree(inorder, istart, pos - 1, postorder, pstart, pstart + pos -1 - istart);
        root.right = buildTree(inorder, pos + 1, iend, postorder,pend  -iend + pos, pend - 1);
        return root;
    }

    public static void  main(String[] args){
        int[] inorder = {1,3,2};
        int[] postorder = {3,2,1};

        ConstructBinaryTreefromInorderandPostorderTraversal cbt = new ConstructBinaryTreefromInorderandPostorderTraversal();
        TreeNode root = cbt.buildTree(inorder, postorder);

        Util.printNode(root);
    }
}
