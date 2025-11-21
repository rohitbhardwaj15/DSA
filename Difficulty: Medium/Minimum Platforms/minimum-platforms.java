class Solution {
    public int minPlatform(int arr[], int dep[]) {
   
        java.util.Arrays.sort(arr);
        java.util.Arrays.sort(dep);

        int n = arr.length;
        int platforms = 1;   
        int result = 1;     
        int i = 1, j = 0;    

        while (i < n && j < n) {
           
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            }
          
            else {
                platforms--;
                j++;
            }
            result = Math.max(result, platforms);
        }
        return result;
    }
}
