package com.leetcode.linkedlist;

import com.leetcode.util.ListNode;

/**
 * Created by guangoon on 17-5-18.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);

        while(head != null){
            ListNode insertNode = head;
            head = head.next;
            insertNode.next = null;
            ListNode curr = dummy;

            while(curr.next != null){
                if(curr.next.val >= insertNode.val) {
                    ListNode nnNext = curr.next;
                    curr.next = insertNode;
                    curr.next.next = nnNext;
                    insertNode = null;
                    break;
                }else{
                    curr = curr.next;
                }
            }

            if(insertNode != null){
                curr.next = insertNode;
            }
        }
        return dummy.next;
    }
}
