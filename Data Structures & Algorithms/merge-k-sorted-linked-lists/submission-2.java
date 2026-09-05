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
        if (lists.length == 0) {
            return null;
        }
        ListNode result = lists[0];
        List<ListNode> mergedLists = Arrays.asList(lists);

        while (mergedLists.size() > 1) {
            List<ListNode> temp = new ArrayList<>();
            for (int i = 0; i < mergedLists.size(); i = i + 2) {
                temp.add(mergeTwo(mergedLists.get(i), (i + 1) < mergedLists.size() ? mergedLists.get(i + 1) : null));
            }
            mergedLists = temp;
        }

        return mergedLists.get(0);
    }

    ListNode mergeTwo(ListNode head1, ListNode head2) {
        ListNode temp = new ListNode();
        ListNode result = temp;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if (head1 != null) {
            temp.next = head1;
        }
        if (head2 != null) {
            temp.next = head2;
        }
        return result.next;
    }
}
