class Solution {

    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) return result;

        // If root is leaf, return only root
        if (isLeaf(root)) {
            result.add(root.data);
            return result;
        }

        // Add root once
        result.add(root.data);

        //  Left Boundary (excluding leaves)
        addLeftBoundary(root.left, result);

        // 2️⃣ Leaf Nodes
        addLeaves(root, result);

        // 3️⃣ Right Boundary (excluding leaves, reversed)
        addRightBoundary(root.right, result);

        return result;
    }

    void addLeftBoundary(Node node, ArrayList<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) {
                result.add(node.data);
            }

            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }

    void addLeaves(Node node, ArrayList<Integer> result) {
        if (node == null) return;

        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }

        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    void addRightBoundary(Node node, ArrayList<Integer> result) {
        Stack<Integer> stack = new Stack<>();

        while (node != null) {
            if (!isLeaf(node)) {
                stack.push(node.data);
            }

            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }

    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
}
