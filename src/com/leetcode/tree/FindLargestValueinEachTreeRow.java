package com.leetcode.tree;

import com.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by guangoon on 6/27/17.
 */
public class FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null)
            return res;
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode x, List<Integer> res, int l){
        if(x != null){
            System.out.println(x.val + " : " + l + " : " + res.size());
            if(l == res.size()){
                res.add(x.val);
            }else{
                if(x.val > res.get(l)){
                    res.set(l, x.val);
                }
            }
            dfs(x.left, res, l + 1);
            dfs(x.right, res, l + 1);
        }
    }
}
