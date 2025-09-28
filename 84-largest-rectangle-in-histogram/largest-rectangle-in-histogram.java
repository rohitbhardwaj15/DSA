

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        int[] extended = Arrays.copyOf(heights, n + 1); // Add sentinel 0

        for (int i = 0; i < extended.length; i++) {
            while (!st.isEmpty() && extended[i] < extended[st.peek()]) {
                int h = extended[st.pop()];
                int width = st.isEmpty() ? i : (i - st.peek() - 1);
                maxArea = Math.max(maxArea, h * width);
            }
            st.push(i);
        }

        return maxArea;
    }
}
