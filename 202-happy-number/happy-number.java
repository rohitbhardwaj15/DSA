import java.util.HashSet;

class Solution {

    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while (n != 1) {

            if (set.contains(n)) {
                return false;   // Cycle detected
            }

            set.add(n);

            n = squareSum(n);
        }

        return true;
    }

    private int squareSum(int n) {

        int sum = 0;

        while (n > 0) {

            int digit = n % 10;

            sum += digit * digit;

            n /= 10;
        }

        return sum;
    }
}