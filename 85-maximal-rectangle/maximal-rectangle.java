class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] prefix = new int[rows][cols];
        int maxArea = 0;

        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    prefix[i][j] = (j == 0 ? 1 : prefix[i][j - 1] + 1);
                } else {
                    prefix[i][j] = 0;
                }
            }
        }

        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (prefix[i][j] == 0) continue;

                int width = prefix[i][j];
                int area = width;
                for (int k = i - 1; k >= 0 && prefix[k][j] != 0; k--) {
                    width = Math.min(width, prefix[k][j]);
                    area = Math.max(area, width * (i - k + 1));
                }

                if (area > maxArea) maxArea = area;
            }
        }

        return maxArea;
    }
}
