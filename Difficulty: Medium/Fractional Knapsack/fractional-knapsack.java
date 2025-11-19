class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        
        
        double[][] items = new double[n][3]; 
        for(int i = 0; i < n; i++) {
            items[i][0] = val[i];          
            items[i][1] = wt[i];         
            items[i][2] = (double) val[i] / wt[i]; 
        }
        
        
        java.util.Arrays.sort(items, (a, b) -> Double.compare(b[2], a[2]));
        
        double maxValue = 0.0;
        
        for(int i = 0; i < n; i++) {
            if(capacity == 0) break;
            
            if(items[i][1] <= capacity) { 
                
                maxValue += items[i][0];
                capacity -= items[i][1];
            } else {
                
                maxValue += items[i][2] * capacity;
                capacity = 0;
            }
        }
        
        return Math.round(maxValue * 1000000.0) / 1000000.0;
    }
}
