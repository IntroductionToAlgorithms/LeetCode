package com.leetcode.linkedlist;

/**
 * Created by guangoon on 17-5-18.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode curr1 = dummy1;
        ListNode curr2 = dummy2;
        while(head != null){
            if(head.val < x){
                curr1.next = head;
                head = head.next;
                curr1 = curr1.next;
            }else{
                curr2.next = head;
                head = head.next;
                curr2 = curr2.next;
            }
        }

        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}
