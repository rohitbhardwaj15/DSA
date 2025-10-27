class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sumMax = 0, sumMin = 0;
        
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] < nums[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                long count = (mid - left) * 1L * (right - mid);
                sumMax += nums[mid] * count;
            }
            st.push(i);
        }
        
        st.clear();
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] > nums[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                long count = (mid - left) * 1L * (right - mid);
                sumMin += nums[mid] * count;
            }
            st.push(i);
        }
        
        return sumMax - sumMin;
    }
}
