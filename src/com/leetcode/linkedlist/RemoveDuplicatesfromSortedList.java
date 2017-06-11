package com.leetcode.linkedlist;

import com.leetcode.util.ListNode;

/**
 * Created by guangoon on 17-4-28.
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head != null && head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return dummy.next;
    }
}
