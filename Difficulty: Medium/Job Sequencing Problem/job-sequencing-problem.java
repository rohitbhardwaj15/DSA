import java.util.*;

class Solution {
    
   
    int find(int parent[], int s){
        if(parent[s] == s) return s;
        return parent[s] = find(parent, parent[s]);
    }
    
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        
        int n = deadline.length;
        
        
        int[][] jobs = new int[n][2];
        for(int i = 0; i < n; i++){
            jobs[i][0] = deadline[i];
            jobs[i][1] = profit[i];
        }
        
        
        Arrays.sort(jobs, (a, b) -> b[1] - a[1]);
        
        
        int maxD = 0;
        for(int d : deadline) maxD = Math.max(maxD, d);
        
        
        int parent[] = new int[maxD + 1];
        for(int i = 0; i <= maxD; i++) parent[i] = i;
        
        int countJobs = 0, maxProfit = 0;
        
        
        for(int[] job : jobs){
            int availableSlot = find(parent, job[0]); 
            
            if(availableSlot > 0){
                parent[availableSlot] = find(parent, availableSlot - 1); 
                countJobs++;
                maxProfit += job[1];
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(countJobs);
        ans.add(maxProfit);
        return ans;
    }
}
