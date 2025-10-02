class Solution {
    public int getKthFromLast(Node head, int k) {
        if (head == null) return -1;

        Node first = head, second = head;

        // advance first k steps
        for (int i = 0; i < k; i++) {
            if (first == null) return -1; // k > length
            first = first.next;
        }

        // move until first reaches end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return (second != null) ? second.data : -1;
    }
}
