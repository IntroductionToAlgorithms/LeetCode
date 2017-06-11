package com.leetcode.linkedlist;

import com.leetcode.util.ListNode;

/**
 * Created by guangoon on 17-4-28.
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lenA = length(headA);
        int lenB = length(headB);
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }

        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }

        while(headA != null && headB != null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public int length(ListNode list){
        int length = 0;
        while(list != null){
            list = list.next;
            length++;
        }
        return length;
    }
}
