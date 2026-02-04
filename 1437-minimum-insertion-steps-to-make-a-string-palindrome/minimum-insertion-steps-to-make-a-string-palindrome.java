class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(s, 0, n - 1, dp);
    }

    private int solve(String s, int i, int j, int[][] dp) {
        
        if (i >= j) return 0;

        
        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = solve(s, i + 1, j - 1, dp);
        } else {
            int insertLeft = solve(s, i + 1, j, dp);
            int insertRight = solve(s, i, j - 1, dp);
            dp[i][j] = 1 + Math.min(insertLeft, insertRight);
        }

        return dp[i][j];
    }
}
