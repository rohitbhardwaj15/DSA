class Solution {
    public int[] getFloorAndCeil(int x, int[] num) {
        int Floor = -1;
        int Ceil = -1;

        for (int val : num) {
            if (val <= x) {
                Floor = Math.max(Floor, val);
            }

            if (val >= x) {
                if (Ceil == -1 || val < Ceil) {
                    Ceil = val;
                }
            }
        }

        return new int[]{Floor, Ceil};
    }
}