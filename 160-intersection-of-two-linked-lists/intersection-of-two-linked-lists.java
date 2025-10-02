/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode tempA = headA;
        ListNode tempB = headB;

        int lengthA = 0, lengthB = 0;

       
        while (tempA != null) {
            lengthA++;
            tempA = tempA.next;
        }

        
        while (tempB != null) {
            lengthB++;
            tempB = tempB.next;
        }

        tempA = headA;
        tempB = headB;

        
        if (lengthA > lengthB) {
            int steps = lengthA - lengthB;
            for (int i = 0; i < steps; i++) {
                tempA = tempA.next;
            }
        } else {
            int steps = lengthB - lengthA;
            for (int i = 0; i < steps; i++) {
                tempB = tempB.next;
            }
        }

        
        while (tempA != null && tempB != null) {
            if (tempA == tempB) {
                return tempA; 
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null; 
    }
}
