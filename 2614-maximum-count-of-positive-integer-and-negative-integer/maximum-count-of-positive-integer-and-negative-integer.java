class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int pos = 0, neg = 0;
        int i = 0;

        while (i < n) {
            if (nums[i] < 0) {
                neg++;
            } else if (nums[i] > 0) {
                pos++;
            }
            i++;
        }

        return Math.max(pos, neg);
    }
}