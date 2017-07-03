package com.leetcode.tree;

import com.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by guangoon on 7/3/17.
 */
public class PathSumII {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return res;
        List<Integer> tmpRes = new LinkedList<Integer>();
        pathSum(root,sum, tmpRes);
        return res;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> tmpRes){
        if(root.left == null && root.right == null && root.val == sum){
            List<Integer> lRes = new LinkedList<>(tmpRes);
            lRes.add(root.val);
            res.add(lRes);
            return;
        }

        tmpRes.add(root.val);
        if(root.left != null)
            pathSum(root.left, sum - root.val, tmpRes);
        if(root.right != null)
            pathSum(root.right, sum - root.val, tmpRes);
        tmpRes.remove(tmpRes.size() - 1);
    }
}
