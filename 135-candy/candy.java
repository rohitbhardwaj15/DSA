class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int total = 1;      
        int up = 0;        
        int down = 0;      
        int peak = 0;       

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {          
                up++;
                peak = up;
                down = 0;
                total += 1 + up;                        
            } else if (ratings[i] == ratings[i - 1]) {   
                up = down = peak = 0;
                total += 1;                       
            } else {                                
                down++;
                up = 0;
              
                total += 1 + down - (peak >= down ? 1 : 0);
            }
        }

        return total;
    }
}
