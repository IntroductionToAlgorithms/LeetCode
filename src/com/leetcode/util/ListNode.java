package com.leetcode.util;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if (next == null) {
            return val + "";
        }
        return val + " -> " + next;
    }
}
