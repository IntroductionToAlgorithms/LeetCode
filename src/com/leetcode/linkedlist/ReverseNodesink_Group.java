package com.leetcode.linkedlist;

/**
 * Created by guangoon on 17-5-19.
 */
public class ReverseNodesink_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode tail = dummy;
        while(true){
            int count = k;
            while(count > 0 && tail != null){
                count--;
                tail = tail.next;
            }
            if(tail == null)
                break;
            head = prev.next;
            while(prev.next != tail){
                ListNode tmp = prev.next;
                prev.next = tmp.next;
                tmp.next = tail.next;
                tail.next = tmp;
            }
            tail = head;
            prev = head;
        }
        return dummy.next;
    }
}
