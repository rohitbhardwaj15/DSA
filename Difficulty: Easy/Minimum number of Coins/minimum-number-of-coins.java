class Solution {
    public int findMin(int n) {
        int[] coins = {10, 5, 2, 1};
        int count = 0;

        for (int coin : coins) {
            count += n / coin;
            n = n % coin;
        }
        return count;
    }
}
