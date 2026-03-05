class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }

        int lo = max, hi = sum, ans = -1;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (requiredDays(mid, weights) <= days) {
                ans = mid;
                hi = mid - 1;
            } 
            else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    public int requiredDays(int capacity, int[] weights) {

        int days = 0;
        int remaining = capacity;

        for (int w : weights) {

            if (remaining >= w)
                remaining -= w;
            else {
                days++;
                remaining = capacity - w;
            }
        }

        days++; 
        return days;
    }
}