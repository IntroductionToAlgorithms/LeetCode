package com.leetcode.linkedlist;

import com.leetcode.util.ListNode;

/**
 * Created by guangoon on 17-5-7.
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode oddListDummy = new ListNode(0);
        ListNode evenListDummy = new ListNode(0);
        ListNode oddListCurr = oddListDummy;
        ListNode evenListCurr = evenListDummy;

        ListNode curr = head;
        ListNode prev = null;
        int index = 1;
        while(curr != null){
            if(index % 2 == 1){
                oddListCurr.next = curr;
                curr = curr.next;
                oddListCurr = oddListCurr.next;
                oddListCurr.next = null;
            }else{
                evenListCurr.next = curr;
                curr = curr.next;
                evenListCurr = evenListCurr.next;
                evenListCurr.next = null;
            }
            index++;
        }
        oddListCurr.next = evenListDummy.next;
        return oddListDummy.next;
    }
}
