/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node insertAtEnd(Node head, int x) {
        // code here
        Node temp = new Node(x);  // create a new node

        if (head == null) {  
            // if list is empty, new node becomes the head
            return temp;
        }

        // traverse to the last node
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        // attach new node at the end
        curr.next = temp;

        return head; // head does not change
    }
}
