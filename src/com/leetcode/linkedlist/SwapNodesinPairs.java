package com.leetcode.linkedlist;

import com.leetcode.util.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by guangoon on 17-5-7.
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);

        ListNode curr = head;
        ListNode dc = dummy;
        while(curr != null && curr.next != null){
            ListNode n1 = curr;
            ListNode n2 = curr.next;
            curr = curr.next.next;
            dc.next = n2;
            dc = dc.next;
            dc.next = n1;
            dc = dc.next;
            dc.next = null;
        }

        if(curr != null){
            dc.next = curr;
        }
        return dummy.next;
    }
}
