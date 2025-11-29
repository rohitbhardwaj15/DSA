class Solution {
    
    static int idx;
    
    
    static void inorder(Node root, ArrayList<Integer> arr) {
        if (root == null) return;
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }
    
    static void postorderFill(Node root, ArrayList<Integer> arr) {
        if (root == null) return;
        
        postorderFill(root.left, arr);
        postorderFill(root.right, arr);
        
        root.data = arr.get(idx++);
    }
    
    public static void convertToMaxHeapUtil(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        
     
        inorder(root, arr);
        
  
        idx = 0;
        postorderFill(root, arr);
    }
}
