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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = n;
        ListNode first = head;
        ListNode second = head;

        while (first.next != null) {
            first = first.next;
            if (count == 0) {
                second = second.next;
            } else {
                count--;
            }
        }

        if (second == head) {
            if(count == 1) {
                return head.next;
            } else if (count == 0) {
                second.next = second.next.next;
            }
            
        } else {
            second.next = second.next.next;
        }
        
        return head;
    }
}
