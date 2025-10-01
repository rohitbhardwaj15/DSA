class Solution {
    public int captureForts(int[] forts) {
        int n = forts.length;
        int maxCaptured = 0;
        int prev = -1; 

        for (int i = 0; i < n; i++) {
            if (forts[i] != 0) {  
                if (prev != -1 && forts[i] != forts[prev]) {
                    
                    maxCaptured = Math.max(maxCaptured, i - prev - 1);
                }
                prev = i; 
            }
        }
        return maxCaptured;
    }
}
