class MyLinkedList {

    // Node definition
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head;   // head of the list
    private int size;    // track size of list

    // Constructor
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // Get value at index
    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    // Add node at head
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Add node at tail
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    // Add node before given index
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return; // invalid
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }

        Node newNode = new Node(val);
        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    // Delete node at given index
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        if (index == 0) {
            head = head.next;
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        size--;
    }
}
