import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Step 1: Copy nums2 into nums1
        for(int i = 0; i < n; i++){
            nums1[m + i] = nums2[i];
        }

        // Step 2: Sort the array
        Arrays.sort(nums1);
    }
}