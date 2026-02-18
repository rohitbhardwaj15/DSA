class Solution {

    public int height(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;

        int leftAns = diameterOfBinaryTree(root.left);
        int rightAns = diameterOfBinaryTree(root.right);

        int mid = height(root.left) + height(root.right);

        return Math.max(mid, Math.max(leftAns, rightAns));
    }
}
