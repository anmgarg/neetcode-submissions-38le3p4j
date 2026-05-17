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
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode result = new ListNode();
        result.val = head.val;
        ListNode temp = result;
        ListNode current = head;

        while(current.next != null) {
            result = new ListNode(current.next.val);
            result.next = temp;
            temp = result;
            current = current.next;
        }
        return result;
        
    }
}
