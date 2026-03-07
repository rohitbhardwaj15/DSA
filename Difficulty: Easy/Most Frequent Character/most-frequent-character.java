class Solution {
    // Function to find the maximum occuring character in a string.
    public static char getMaxOccuringChar(String s) {

        // s -> character
        int n = s.length();
        int maxFreq = -1;
        char ans = s.charAt(0);

        for (int i = 0; i < n; i++) {
            int freq = 1;
            char ch = s.charAt(i);

            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == ch)
                    freq++;
            }

            if (freq > maxFreq) {
                maxFreq = freq;
                ans = ch;
            } 
            else if (freq == maxFreq && ch < ans) {
                ans = ch;
            }
        }

        return ans;
    }
}