class Solution {
    public int maxNumberOfBalloons(String text) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : text.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        
        String target = "balloon";

        int ans = Integer.MAX_VALUE;

        for (char ch : target.toCharArray()) {

            int count = map.getOrDefault(ch, 0);

            if (ch == 'l' || ch == 'o') {
                count = count / 2;
            }

            ans = Math.min(ans, count);
        }

        return ans;
    }
}