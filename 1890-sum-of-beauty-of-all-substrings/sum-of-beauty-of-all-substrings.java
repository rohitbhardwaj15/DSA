class Solution {
    public int beautySum(String s) {

        int n = s.length();
        int total = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {

                int[] freq = new int[26];

                for(int k = i; k <= j; k++) {
                    freq[s.charAt(k) - 'a']++;
                }

                int max = 0;
                int min = Integer.MAX_VALUE;

                for(int f : freq) {
                    if(f > 0) {
                        max = Math.max(max, f);
                        min = Math.min(min, f);
                    }
                }

                total += (max - min);
            }
        }

        return total;
    }
}