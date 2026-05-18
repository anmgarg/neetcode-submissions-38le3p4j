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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode result = new ListNode();
        ListNode temp = result;
        ListNode current1 = list1;
        ListNode current2 = list2;
        while(current1 != null && current2 != null) {
            if(current1.val < current2.val) {
                temp.val = current1.val;
                current1 = current1.next;
            } else {
                temp.val = current2.val;
                current2 = current2.next;
            }
            if (current1 == null) {
                temp.next = current2;
                break;
            }
            if (current2 == null) {
                temp.next = current1;
                break;
            }
            temp.next = new ListNode();
            temp = temp.next;
        }
        return result;
    }
}