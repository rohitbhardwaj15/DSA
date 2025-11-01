class Solution {

    public boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        
        invertTree(root.left);

        
        return isSame(root.left, root.right);
    }
}
