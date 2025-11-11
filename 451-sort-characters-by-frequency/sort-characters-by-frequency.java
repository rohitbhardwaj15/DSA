class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> freq.get(b) - freq.get(a)
        );
        pq.addAll(freq.keySet());

        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty()) {
            char ch = pq.poll();
            int count = freq.get(ch);
            for(int i = 0; i < count; i++){
                result.append(ch);
            }
        }

        return result.toString();
    }
}
