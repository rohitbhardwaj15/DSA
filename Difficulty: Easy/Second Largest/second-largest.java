class Solution {
    public int getSecondLargest(int[] arr) {
        
        int n = arr.length;
        if (n < 2) return -1;

        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            
            if (arr[i] > max) {
                second = max;
                max = arr[i];
            }
            else if (arr[i] > second && arr[i] < max) {
                second = arr[i];
            }
        }

        if (second == Integer.MIN_VALUE)
            return -1;

        return second;
    }
}