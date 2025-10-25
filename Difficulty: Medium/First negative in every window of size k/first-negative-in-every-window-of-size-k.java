import java.util.*;

class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                q.add(i);
            }
        }

        for (int i = 0; i < n - k + 1; i++) {
            
            while (!q.isEmpty() && q.peek() < i)
                q.remove();

            
            if (!q.isEmpty() && q.peek() <= i + k - 1)
                res.add(arr[q.peek()]);
            else
                res.add(0);
        }

        return res;
    }

    
}


