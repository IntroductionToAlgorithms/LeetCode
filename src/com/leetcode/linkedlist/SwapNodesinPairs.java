package com.leetcode.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by guangoon on 17-5-7.
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        Queue<ListNode> q1 = new LinkedList<ListNode>();
        Queue<ListNode> q2 = new LinkedList<ListNode>();
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode prev = null;
        while(head != null && head.next != null){
            q1.offer(head);
            prev = head;
            head = head.next;
            prev.next = null;
            q2.offer(head);
            prev = head;
            head = head.next;
            prev.next = null;
        }
        if(head != null)
            q1.offer(head);
        while(!q2.isEmpty() && !q1.isEmpty()){
            curr.next = q2.poll();
            curr = curr.next;
            curr.next = q1.poll();
            curr = curr.next;
        }
        if(!q1.isEmpty())
            curr.next = q1.poll();
        return dummy.next;
    }
}
