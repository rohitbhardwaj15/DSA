class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int totalSum = 0;
        
        int currentMax = 0;
        int maxSum = Integer.MIN_VALUE;
        
        int currentMin = 0;
        int minSum = Integer.MAX_VALUE;
        
        for (int num : nums) {
            
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);
            
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
            
            totalSum += num;
        }
        
        
        if (maxSum < 0) {
            return maxSum;
        }
        
        return Math.max(maxSum, totalSum - minSum);
    }
}
