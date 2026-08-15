class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int[] countP = new int[26];
        int[] countWindow = new int[26];

        // Frequency of characters in p
        for (char ch : p.toCharArray()) {
            countP[ch - 'a']++;
        }

        int k = p.length();

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            countWindow[s.charAt(right) - 'a']++;

            // Keep window size equal to p.length()
            if (right >= k) {
                countWindow[s.charAt(right - k) - 'a']--;
            }

            // Check if window is an anagram
            if (Arrays.equals(countP, countWindow)) {
                result.add(right - k + 1);
            }
        }

        return result;
    }
}