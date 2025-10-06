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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head; 
        ListNode fast = head;

        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        
        ListNode temp = reverse(slow.next);
        slow.next = temp;

        
        ListNode P1 = head;
        ListNode P2 = slow.next;
        while (P2 != null) {
            if (P1.val != P2.val) return false;
            P1 = P1.next;
            P2 = P2.next;
        } 
        return true;
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
