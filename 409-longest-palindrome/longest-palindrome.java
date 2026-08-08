import java.util.*;

class Solution {
    public int longestPalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        boolean odd = false;
        int res = 0;

        // Traverse the HashMap
        for (int val : map.values()) {

            if (val % 2 == 0) {
                // Even frequency: use all characters
                res += val;
            } 
            else {
                // Odd frequency: use val - 1 characters
                res += val - 1;
                odd = true;
            }
        }

        // One odd character can be placed in the center
        if (odd == true) {
            return res + 1;
        }

        return res;
    }
}