/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        // 1. Break in two halves.

        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;

        // 2. Reverse the second half.
        ListNode ahead = second;
        ListNode temp = second;
        ListNode prev = null;

        while(ahead != null) {
            ahead = ahead.next;
            temp.next = prev;
            prev = temp;
            temp = ahead;
        }
        second = prev;
        
        // 3. Merge th two halves.
        ListNode first = head;
        while(second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;

        }
    }
}
