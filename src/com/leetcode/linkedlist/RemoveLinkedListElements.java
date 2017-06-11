package com.leetcode.linkedlist;

import com.leetcode.util.ListNode;

/**
 * Created by guangoon on 17-4-28.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode list = dummy;
        while(list.next != null){
            if(list.next.val == val){
                list.next = list.next.next;
            }else{
                list = list.next;
            }
        }
        return dummy.next;
    }
}
