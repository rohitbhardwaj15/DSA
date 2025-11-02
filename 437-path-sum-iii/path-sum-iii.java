class Solution {

    public int noofpaths(TreeNode root, long targetSum){
        if (root == null) return 0;

        int count = 0;

        if ((long) root.val == targetSum)   
            count++;

        count += noofpaths(root.left, targetSum - (long) root.val);
        count += noofpaths(root.right, targetSum - (long) root.val);

        return count;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int count = noofpaths(root, (long) targetSum);

        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);

        return count;
    }
}
