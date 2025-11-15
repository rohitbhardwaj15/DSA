public class Solution {
    private void helper(TreeNode root, int low, int high) {
        if (root == null) return;

        while (root.left != null) {
            if (root.left.val < low) root.left = root.left.right;
            else if (root.left.val > high) root.left = root.left.left;
            else break;
        }

        
        while (root.right != null) {
            if (root.right.val < low) root.right = root.right.right;
            else if (root.right.val > high) root.right = root.right.left;
            else break;
        }

        helper(root.left, low, high);
        helper(root.right, low, high);
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode parent = new TreeNode(Integer.MAX_VALUE); 
        parent.left = root;
        helper(parent, low, high);
        return parent.left;
    }
}
