class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;

        for (int ele : piles) {
            max = Math.max(max, ele);
        }

        int lo = 1, hi = max, ans = max;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (hours(piles, mid) <= h) {
                ans = mid;
                hi = mid - 1;
            } 
            else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    public long hours(int[] piles, int speed) {

        long hours = 0;

        for (int ele : piles) {
            hours += (ele + speed - 1) / speed;  
        }

        return hours;
    }
}