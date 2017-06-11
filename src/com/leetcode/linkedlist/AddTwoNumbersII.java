package com.leetcode.linkedlist;

import com.leetcode.util.ListNode;

import java.util.Stack;

/**
 * Created by guangoon on 17-5-7.
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();
        while(l1 != null){
            s1.push(l1);
            l1 = l1.next;
        }

        while(l2 != null){
            s2.push(l2);
            l2 = l2.next;
        }
        ListNode head = null;
        int curry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int sum = (s1.isEmpty() ? 0 : s1.pop().val) + (s2.isEmpty() ? 0 : s2.pop().val) + curry;
            curry = sum / 10;
            ListNode listNode = new ListNode(sum %10);
            listNode.next = head;
            head = listNode;
        }

        if(curry > 0){
            ListNode listNode = new ListNode(curry %10);
            listNode.next = head;
            head = listNode;
        }

        return head;
    }
}
