package com.leetcode.linkedlist;

import com.leetcode.util.ListNode;

/**
 * Created by guangoon on 17-5-6.
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        n = n % getLength(head);
        if(n <= 0 )
            return head.next;
        ListNode fast = head;
        ListNode slow = head;
        while(n > 0){
            fast = fast.next;
            n--;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public int getLength(ListNode head){
        int len = 0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }
}
