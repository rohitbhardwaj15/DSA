 class Solution {
    public void sortColors(int[] nums) {
        int i = 0;          // pointer for 0s
        int j = 0;          // current pointer
        int k = nums.length - 1; // pointer for 2s

        while (j <= k) {
            if (nums[j] == 1) {
                j++;
            } 
            else if (nums[j] == 2) {
                swap(nums, j, k);
                k--;
            } 
            else { // nums[j] == 0
                swap(nums, i, j);
                i++;
                j++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
