import java.util.*;

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return canCut(rectangles, 0, 2) || canCut(rectangles, 1, 3);
    }

    private boolean canCut(int[][] rects, int startIndex, int endIndex) {
        int m = rects.length;
        int[][] arr = new int[m][2];

        for (int i = 0; i < m; i++)
            arr[i] = new int[]{rects[i][startIndex], rects[i][endIndex]};

        
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

      
        int[] prefixMax = new int[m];
        prefixMax[0] = arr[0][1];
        for (int i = 1; i < m; i++)
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i][1]);

       
        int[] suffixMin = new int[m];
        suffixMin[m - 1] = arr[m - 1][0];
        for (int i = m - 2; i >= 0; i--)
            suffixMin[i] = Math.min(suffixMin[i + 1], arr[i][0]);

        for (int i = 0; i < m - 2; i++) {
            if (prefixMax[i] <= suffixMin[i + 1]) {  
                for (int j = i + 1; j < m - 1; j++) {
                    if (prefixMax[j] <= suffixMin[j + 1])  
                        return true;
                }
            }
        }
        return false;
    }
}
