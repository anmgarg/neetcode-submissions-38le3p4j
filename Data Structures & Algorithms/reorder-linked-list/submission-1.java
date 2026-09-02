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
        ListNode slow = head;
        ListNode fast = head;
        ListNode result = new ListNode();
        ListNode tempResult = result;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        ListNode reversedSecondHalf = reverse(slow.next);

        slow.next = null;

        ListNode temp = head;
        ListNode temp2 = reversedSecondHalf;
        while(temp != null && temp2 != null) {
            result.next = temp;
            temp = temp.next;
            result = result.next;
            result.next = temp2;
            result = result.next;
            temp2 = temp2.next;
        }

        if (temp != null) {
            result.next = temp;
        }
        head = tempResult.next;
    }

    public ListNode reverse(ListNode head) {

        ListNode temp = head;
        ListNode result = null;

        while(temp != null) {
            ListNode temp2 = temp;
            temp = temp.next;
            temp2.next = result;
            result = temp2; 
        }

        return result;

    }


}
