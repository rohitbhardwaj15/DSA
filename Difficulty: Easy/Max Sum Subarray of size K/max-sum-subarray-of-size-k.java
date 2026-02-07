class Solution {
    public int maxSubarraySum(int[] arr, int k) {

        int n = arr.length;

        // Step 1: sum of first window of size k
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Step 2: slide the window
        for (int i = k; i < n; i++) {
            windowSum += arr[i];       // add new element
            windowSum -= arr[i - k];   // remove old element

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
