package com.leetcode.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by guangoon on 6/27/17.
 */
public class Util {
    public static TreeNode buildTreeNode(String input){
        String[] a = input.substring(1, input.length() - 1).split(",");
        System.out.println(Arrays.toString(a));
        Queue<String> queue = new LinkedList<>();
        for(String string : a)
            queue.offer(string);
        Queue<TreeNode> qt = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(queue.poll()));
        qt.offer(root);
        while(!qt.isEmpty()){
            TreeNode x = qt.poll();
            if(queue.isEmpty())
                break;
            String vl = queue.poll();
            if(isNumeric(vl)){
                x.left = new TreeNode(Integer.parseInt(vl));
                qt.offer(x.left);
            }

            if(queue.isEmpty())
                break;
            String vr = queue.poll();
            if(isNumeric(vr)){
                x.right = new TreeNode(Integer.parseInt(vr));
                qt.offer(x.right);
            }

        }
        return root;
    }

    public void printTreeNode(TreeNode root){

    }

    public static  boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
