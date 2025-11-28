class Solution {
    
    
    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {

        
        int[] merged = new int[n + m];

        
        for (int i = 0; i < n; i++)
            merged[i] = a[i];

        
        for (int i = 0; i < m; i++)
            merged[n + i] = b[i];

        
        int size = n + m;
        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(merged, size, i);

        return merged;
    }
}
