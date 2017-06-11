package com.leetcode.linkedlist;

import com.leetcode.util.ListNode;
import com.leetcode.util.TreeNode;

/**
 * Created by guangoon on 17-5-6.
 */
public class ConvertSortedListtoBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        TreeNode treeNode = new TreeNode(slow.val);
        System.out.println(slow.val);
        treeNode.left = sortedListToBST(head);
        treeNode.right = sortedListToBST(slow.next);
        return treeNode;
    }
}
