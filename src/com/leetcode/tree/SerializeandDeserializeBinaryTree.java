package com.leetcode.tree;

import com.leetcode.util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by guangoon on 7/7/17.
 */
public class SerializeandDeserializeBinaryTree {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if(root != null){
                int maxLevel = maxDepth(root);
                Queue<TreeNode> q = new LinkedList<TreeNode>();
                sb.append(root.val);
                q.offer(root);
                int size = 1;
                int level = 0;
                while(size > 0){
                    int index = 0;
                    level++;
                    while(!q.isEmpty() && index < size){
                        TreeNode x = q.poll();
                        if((level + 1) == maxLevel){
                            if(x.left != null){
                                sb.append("," + x.left.val );
                            }else{
                                sb.append(",null");
                            }

                            if(x.right != null){
                                sb.append("," +x.right.val);
                            }else if((index + 1) != size){
                                sb.append(",null");
                            }
                        }else{
                            if(x.left != null){
                                sb.append("," + x.left.val );
                                q.offer(x.left);
                            }else{
                                sb.append(",null");
                            }

                            if(x.right != null){
                                sb.append("," + x.right.val );
                                q.offer(x.right);
                            }else{
                                sb.append(",null");
                            }
                        }
                        index++;
                    }
                    size = q.size();
                }
            }
            sb.append("]");
            return sb.toString();
        }

        public int maxDepth(TreeNode root) {
            if(root==null){
                return 0;
            }
            return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            System.out.println(data);
            if(data.length() < 3)
                return null;
            String[] a = data.substring(1, data.length() - 1).split(",");
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
                if(!"null".equals(vl)){
                    x.left = new TreeNode(Integer.parseInt(vl));
                    qt.offer(x.left);
                }

                if(queue.isEmpty())
                    break;
                String vr = queue.poll();
                if(!"null".equals(vr)){
                    x.right = new TreeNode(Integer.parseInt(vr));
                    qt.offer(x.right);
                }
            }
            return root;
        }
}
