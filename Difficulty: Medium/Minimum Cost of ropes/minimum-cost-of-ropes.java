class Solution {
    public static int minCost(int[] arr) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int x : arr) {
            pq.add(x);
        }

        int totalCost = 0;

       
        while (pq.size() > 1) {
            int a = pq.poll();   
            int b = pq.poll();   

            int cost = a + b;    
            totalCost += cost;

            pq.add(cost);        
        }

        return totalCost;
    }
}
