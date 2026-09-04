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
        int count = 0;
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode slow = temp;
        ListNode fast = temp;
        while (fast.next != null) {
            if (count == n) {
                slow = slow.next;
            } else {
                count++;
            }
            fast = fast.next;
        }
        if (slow == temp) {
            return slow.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
