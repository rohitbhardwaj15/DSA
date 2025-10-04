// User function Template for Java

/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int key) {
        Node current = head;

        while (current != null) {
            if (current.data == key) {
                Node nextNode = current.next;

                
                if (current.prev == null) {
                    head = nextNode;
                    if (head != null) {
                        head.prev = null;
                    }
                } 
               
                else {
                    current.prev.next = current.next;
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                }

                current = nextNode;
            } else {
                current = current.next;
            }
        }

        return head; 
    }
}
