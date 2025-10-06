class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int index = 1;
        int firstCritical = -1;
        int lastCritical = -1;
        int minDist = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr.next != null) {
            int prevVal = prev.val;
            int currVal = curr.val;
            int nextVal = curr.next.val;

            if ((currVal > prevVal && currVal > nextVal) ||
                (currVal < prevVal && currVal < nextVal)) {

                if (firstCritical == -1) {
                    firstCritical = index;
                } else {
                    minDist = Math.min(minDist, index - lastCritical);
                }
                lastCritical = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        if (firstCritical == -1 || firstCritical == lastCritical)
            return new int[]{-1, -1};

        int maxDist = lastCritical - firstCritical;
        return new int[]{minDist, maxDist};
    }
}
