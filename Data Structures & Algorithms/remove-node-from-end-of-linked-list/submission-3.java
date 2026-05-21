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
        if(head.next == null) {
            return null;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode dummy2 = dummy;
        ListNode temp = head;
        
        while(n > 0) {
            temp = temp.next;
            n--;
        }

        while(temp != null) {
            dummy = dummy.next;
            temp = temp.next;
        }

        dummy.next = dummy.next.next;

        return dummy2.next;
    }
}
