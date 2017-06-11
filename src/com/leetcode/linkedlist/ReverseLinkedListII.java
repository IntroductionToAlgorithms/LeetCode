package com.leetcode.linkedlist;

import com.leetcode.util.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by guangoon on 17-5-18.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int index = 1;
        while(index < m){
            prev = prev.next;
            index++;
        }

        ListNode tail = prev.next;

        index = m;
        while(index < n){
            tail = tail.next;
            index++;
        }

        while(prev.next != tail){
            ListNode tmp = prev.next;
            prev.next = tmp.next;
            tmp.next = tail.next;
            tail.next = tmp;
        }
        return dummy.next;
    }
}
