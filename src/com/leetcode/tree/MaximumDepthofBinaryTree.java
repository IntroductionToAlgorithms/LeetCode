package com.leetcode.tree;

/**Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Subscribe to see which companies asked this question
*/

public class MaximumDepthofBinaryTree {
	private int maxDeep = 0;
	public static void main(String[] args) {

	}
	
    public int maxDepth(TreeNode root) {
        if(root == null)
        	return maxDeep;
        maxDeep++;
        maxDepth(root.left, 1);
        maxDepth(root.right, 1);
        return maxDeep;
    }
    
    public void maxDepth(TreeNode node, int depth){
    	if(node == null)
    		return;
    	depth++;
    	maxDeep = Math.max(maxDeep, depth);
    	maxDepth(node.left, depth);
    	maxDepth(node.right, depth);
    }

}
