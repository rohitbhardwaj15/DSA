import java.util.*;

class Solution {

    public static int aggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls);

        int lo = 1;
        int hi = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (canPlace(stalls, k, mid)) {
                ans = mid;
                lo = mid + 1;  
            } 
            else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    static boolean canPlace(int[] stalls, int k, int dist) {

        int cows = 1;
        int last = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - last >= dist) {
                cows++;
                last = stalls[i];
            }

            if (cows >= k)
                return true;
        }

        return false;
    }
}