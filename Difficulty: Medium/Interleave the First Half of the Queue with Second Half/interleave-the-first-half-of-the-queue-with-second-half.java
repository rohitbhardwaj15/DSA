

class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        int n = q.size();
        if (n % 2 != 0) return; 
        int half = n / 2;
        Queue<Integer> firstHalf = new LinkedList<>();

        for (int i = 0; i < half; i++) {
            firstHalf.add(q.remove());
        }

        
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());          
        }
    }

    
}
