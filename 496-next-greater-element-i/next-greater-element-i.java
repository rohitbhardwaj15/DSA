class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        res[n - 1] = -1;
        st.push(nums2[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && st.peek() <= nums2[i])
                st.pop();

            if (st.size() == 0) res[i] = -1;
            else res[i] = st.peek();

            st.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    ans[i] = res[j];
                    break;
                }
            }
        }

        return ans;
    }
}
