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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;
        ListNode end = dummy;

        while (true) {
            int count = 0;
            while (count < k && end != null) {
                end = end.next;
                count++;
            }

            if (end == null) break;

            ListNode start = prevGroup.next; 
            ListNode nextGroup = end.next;
            end.next = null;

            
            prevGroup.next = reverse(start);
            start.next = nextGroup;

            
            prevGroup = start;
            end = prevGroup;
        }

        return dummy.next; 
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
