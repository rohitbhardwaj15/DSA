class MinStack {
    private Stack<Long> st;
    private long min;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        long value = val;
        if (st.isEmpty()) {
            st.push(value);
            min = value;
        } else if (value >= min) {
            st.push(value);
        } else {
        
            st.push(2 * value - min);
            min = value;
        }
    }

    public void pop() {
        if (st.isEmpty()) return;
        long top = st.pop();
        if (top < min) {
            min = 2 * min - top;
        }
    }

    public int top() {
        long top = st.peek();
        if (top < min) {
            
            return (int) min;
        } else {
            return (int) top;
        }
    }

    public int getMin() {
        return (int) min;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */