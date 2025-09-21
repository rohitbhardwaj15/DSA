
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> curr, int k, int n, int start) {
        if (curr.size() == k && n == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (curr.size() >= k || n <= 0) return;
        for (int i = start; i <= 9; i++) {
            curr.add(i);
            backtrack(res, curr, k, n - i, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
