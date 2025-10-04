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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find the length of the list
        ListNode temp = head;
        int n = 1; // at least one node exists
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }

        // Step 2: Connect the last node to the head to form a circular list
        temp.next = head;

        // Step 3: Find the new tail: (n - k % n - 1)th node
        // and the new head: (n - k % n)th node
        k = k % n;
        int stepsToNewHead = n - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        // Step 4: Break the circle
        newTail.next = null;

        return newHead;
    }
}
