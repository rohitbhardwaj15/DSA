class Solution {
    
    private int maxSum;
    
    private int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = solve(root.left);
        int right = solve(root.right);
        
        int neecheHiMilgayaAnswer = left + right + root.val; 
        int koiEkAcha = Math.max(left, right) + root.val; 
        int onlyRootAcha = root.val; 

        maxSum = Math.max(maxSum, Math.max(neecheHiMilgayaAnswer, Math.max(koiEkAcha, onlyRootAcha)));
        
        
        return Math.max(koiEkAcha, onlyRootAcha);
    }
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}