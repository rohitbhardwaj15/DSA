import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1); 
        
        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            int remainder = sum % k;

            // Handle negative remainder
            if (remainder < 0) {
                remainder += k;
            }

            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
