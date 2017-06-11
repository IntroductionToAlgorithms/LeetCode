package com.leetcode.linkedlist;

import com.leetcode.util.ListNode;

/**
 * Created by guangoon on 17-4-28.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode curr = head;
        int len = length(head);
        k = k % len;
        if(k == 0)
            return head;
        while(k > 0){
            curr = curr.next;
            k--;
        }

        ListNode p = head;
        while(curr.next != null){
            p = p.next;
            curr = curr.next;
        }

        ListNode nHead = p.next;
        p.next = null;
        curr.next = head;
        return nHead;
    }
    public int length(ListNode head){
        int len = 0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }
}
