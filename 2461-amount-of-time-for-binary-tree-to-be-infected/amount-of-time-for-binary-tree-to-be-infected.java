class Solution {

    public TreeNode getNode(TreeNode root, int start) {
        if (root == null) return null;
        if (root.val == start) return root;

        TreeNode left = getNode(root.left, start);
        TreeNode right = getNode(root.right, start);

        if (left == null) return right;
        else return left;
    }

    public void preorder(TreeNode root, Map<TreeNode, TreeNode> P) {
        if (root == null) return;

        if (root.left != null) P.put(root.left, root);
        if (root.right != null) P.put(root.right, root);

        preorder(root.left, P);
        preorder(root.right, P);
    }

    public int amountOfTime(TreeNode root, int start) {

        TreeNode node = getNode(root, start);

        Map<TreeNode, TreeNode> P = new HashMap<>();
        preorder(root, P);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);

        Map<TreeNode, Integer> v = new HashMap<>();
        v.put(node, 0);

        while (q.size() > 0) {
            TreeNode temp = q.peek();
            int level = v.get(temp);

            if (temp.left != null && !v.containsKey(temp.left)) {
                q.add(temp.left);
                v.put(temp.left, level + 1);
            }

            if (temp.right != null && !v.containsKey(temp.right)) {
                q.add(temp.right);
                v.put(temp.right, level + 1);
            }

            if (P.containsKey(temp) && !v.containsKey(P.get(temp))) {
                q.add(P.get(temp));
                v.put(P.get(temp), level + 1);
            }

            q.remove();
        }

        int max = -1;
        
        for (int Level : v.values()) {
            max = Math.max(max, Level);
        }

        return max;
    }
}
