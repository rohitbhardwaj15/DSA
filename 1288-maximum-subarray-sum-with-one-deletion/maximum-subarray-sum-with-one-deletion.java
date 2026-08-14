class Solution {
    public int maximumSum(int[] arr) {
        int noDelete = arr[0];
        int oneDelete = -1000000000;
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int newNoDelete = Math.max(
                arr[i],
                noDelete + arr[i]
            );

            int newOneDelete = Math.max(
                oneDelete + arr[i],
                noDelete
            );

            noDelete = newNoDelete;
            oneDelete = newOneDelete;

            ans = Math.max(ans, Math.max(noDelete, oneDelete));
        }

        return ans;
    }
}