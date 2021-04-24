package com.leetcode.linkedlist;

import com.leetcode.util.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in
 * reverse order and each of their nodes contain a single digit. Add the two numbers and return it
 * as a linked list. Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            current = current.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            current = current.next;
            l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        // 类似于AddTwoNumbersII的优化
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            int sum = v1 + v2 + carry;
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            current = current.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        String sl1 = "2>4>3";
        String sl2 = "5>6>6>2";

        String[] asl1 = sl1.split(">");
        String[] asl2 = sl2.split(">");
        if (asl1.length == 0 || asl2.length == 0) {
            return;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode c1 = dummy1;
        ListNode c2 = dummy2;
        for (String string : asl1) {
            c1.next = new ListNode(Integer.parseInt(string));
            c1 = c1.next;
        }

        for (String string : asl2) {
            c2.next = new ListNode(Integer.parseInt(string));
            c2 = c2.next;
        }

        System.out.println(addTwoNumbers(dummy1.next, dummy2.next));
        System.out.println(addTwoNumbers2(dummy1.next, dummy2.next));
    }
}
