package com.leetcode.linkedlist;

/**
 * Created by guangoon on 17-4-28.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode middle = reverse(slow);

        while(middle != null){
            System.out.println(middle.val);
            System.out.println(head.val);
            if(middle.val != head.val){
                return false;
            }
            middle = middle.next;
            head = head.next;
        }

        return true;
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head.next;
        ListNode p = null;
        head.next = null;
        while(curr != null){
            p = curr;
            curr = curr.next;
            p.next = head;
            head = p;
        }
        return head;
    }
}
