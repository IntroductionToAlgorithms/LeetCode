package com.leetcode.linkedlist;

import com.leetcode.util.ListNode;

/**
 * Created by guangoon on 17-5-19.
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);

        dummy.next = head;
        ListNode curr = dummy;
        while(curr != null && curr.next != null && curr.next.next != null){
            ListNode x = curr.next.next;
            while(x != null && curr.next.val == x.val){
                x = x.next;
            }

            if(curr.next.next != x){
                curr.next = x;
            }
            else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
