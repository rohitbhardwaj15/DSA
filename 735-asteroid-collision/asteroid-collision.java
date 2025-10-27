import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            while (!st.isEmpty() && a < 0 && st.peek() > 0) {
                if (st.peek() < -a) {
                    st.pop(); 
                    continue;
                } else if (st.peek() == -a) {
                    st.pop(); 
                }
                destroyed = true; 
                break;
            }

            if (!destroyed) {
                st.push(a);
            }
        }

        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }

        return res;
    }

    
}
