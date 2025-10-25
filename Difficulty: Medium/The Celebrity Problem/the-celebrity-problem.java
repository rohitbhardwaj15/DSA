

class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        Stack<Integer> st = new Stack<>();

        
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        
        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();

            if (mat[a][b] == 1) {
                
                st.push(b);
            } else {
                
                st.push(a);
            }
        }

        
        if (st.isEmpty()) return -1;

        int potential = st.pop();

        
        for (int j = 0; j < n; j++) {
            if (j != potential && mat[potential][j] == 1) return -1;
        }

        
        for (int i = 0; i < n; i++) {
            if (i != potential && mat[i][potential] == 0) return -1;
        }

        return potential;
    }

    
}
