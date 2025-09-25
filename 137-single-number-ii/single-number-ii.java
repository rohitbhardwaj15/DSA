 class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            twos |= ones & num;
            ones ^= num;
            int common = ones & twos;
            ones &= ~common;
            twos &= ~common;
        }
        return ones;
    }
 }