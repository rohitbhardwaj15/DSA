class Solution {
    public void segregate0and1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            // 0 is already in correct position
            while (left < right && arr[left] == 0) {
                left++;
            }

            // 1 is already in correct position
            while (left < right && arr[right] == 1) {
                right--;
            }

            // arr[left] = 1 and arr[right] = 0
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
    }
}