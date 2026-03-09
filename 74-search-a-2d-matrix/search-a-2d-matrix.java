class Solution {

    public boolean searchInRow(int[][] mat, int target, int row) {

        int n = mat[0].length;
        int st = 0, end = n - 1;

        while (st <= end) {

            int mid = st + (end - st) / 2;

            if (target == mat[row][mid]) {
                return true;
            } 
            else if (target > mat[row][mid]) {
                st = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] mat, int target) {

        int m = mat.length;
        int n = mat[0].length;

        int startRow = 0, endRow = m - 1;

        while (startRow <= endRow) {

            int midRow = startRow + (endRow - startRow) / 2;

            if (target >= mat[midRow][0] && target <= mat[midRow][n - 1]) {
                return searchInRow(mat, target, midRow);
            } 
            else if (target > mat[midRow][n - 1]) {
                startRow = midRow + 1;
            } 
            else {
                endRow = midRow - 1;
            }
        }

        return false;
    }
}