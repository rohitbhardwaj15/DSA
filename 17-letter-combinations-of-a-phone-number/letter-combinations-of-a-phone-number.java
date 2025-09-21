

class Solution {
    private static final String[] map = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        backtrack(res, new StringBuilder(), digits, 0);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder curr, String digits, int index) {
        if (index == digits.length()) {
            res.add(curr.toString());
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            curr.append(c);
            backtrack(res, curr, digits, index + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}

