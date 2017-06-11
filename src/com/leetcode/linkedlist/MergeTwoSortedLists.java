package com.leetcode.linkedlist;

import com.leetcode.util.ListNode;

/**
 * Created by guangoon on 17-4-28.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1 != null){
            curr.next = l1;
        }

        if(l2 != null){
            curr.next = l2;
        }

        return dummy.next;
    }
}
