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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, null);
        ListNode result = dummy;
        boolean alive = true;

        while(alive) {
            int lowestNodeIndex = -1;
            alive = false;
            for(int i=0; i<lists.length; i++) {
                if (lists[i] != null) {
                    alive = true;
                    if (lowestNodeIndex == -1) {
                        lowestNodeIndex = i;
                        continue;
                    }
                    if (lists[i].val 
                            < lists[lowestNodeIndex].val) {
                        lowestNodeIndex = i;
                    }
                }
            }
            if (alive) {
                dummy.next = lists[lowestNodeIndex];
                lists[lowestNodeIndex] = lists[lowestNodeIndex].next;
                dummy = dummy.next;
            }
        }
        return result.next;
    }
}
