class Solution {
     
    public int maxMeetings(int start[], int end[]) {
        
        int n = start.length;
        
        
        int arr[][] = new int[n][2];
        
        
        for(int i = 0; i < n; i++){
            arr[i][0] = start[i]; 
            arr[i][1] = end[i];  
        }
        
        
        java.util.Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        
        int count = 1;          
        int lastEnd = arr[0][1];      
        
        
        for(int i = 1; i < n; i++){
            if(arr[i][0] > lastEnd){  
                count++;
                lastEnd = arr[i][1];
            }
        }
        
        return count;
    }
}
