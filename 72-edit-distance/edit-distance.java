class Solution {

    public int minsteps(int i, int j, StringBuilder a, StringBuilder b, int[][] dp) {


        if (i < 0) return j + 1;  
        if (j < 0) return i + 1;  

        if (dp[i][j] != -1) return dp[i][j];


        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = minsteps(i - 1, j - 1, a, b, dp);
        } 
        else {
            int delete = minsteps(i - 1, j, a, b, dp);     
            int insert = minsteps(i, j - 1, a, b, dp);      
            int replace = minsteps(i - 1, j - 1, a, b, dp); 

            return dp[i][j] = 1 + Math.min(delete, Math.min(insert, replace));
        }
    }

    public int minDistance(String word1, String word2) {
        StringBuilder a = new StringBuilder(word1);
        StringBuilder b = new StringBuilder(word2);

        int m = a.length(), n = b.length();
        int[][] dp = new int[m][n];

    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return minsteps(m - 1, n - 1, a, b, dp);
    }
}
