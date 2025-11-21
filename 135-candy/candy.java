class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int total = 1;      // candies for the first child
        int up = 0;         // length of current upward slope
        int down = 0;       // length of current downward slope
        int peak = 0;       // length of last upward slope (peak height)

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {          // going up
                up++;
                peak = up;
                down = 0;
                total += 1 + up;                        // base 1 + extra for upward slope
            } else if (ratings[i] == ratings[i - 1]) {   // flat
                up = down = peak = 0;
                total += 1;                             // just 1 candy
            } else {                                    // going down
                down++;
                up = 0;
                // give child (1 + down) candies for descending part,
                // but if peak >= down, we've already given enough to the peak so subtract 1
                total += 1 + down - (peak >= down ? 1 : 0);
            }
        }

        return total;
    }
}
