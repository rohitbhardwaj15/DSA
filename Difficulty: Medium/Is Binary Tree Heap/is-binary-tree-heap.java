/*
class Node {
    int data;
    Node left, right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {

 
    private int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

   
    private boolean isCBT(Node root, int index, int totalNodes) {
        if (root == null) return true;

        
        if (index >= totalNodes) return false;

        return isCBT(root.left, 2 * index + 1, totalNodes) &&
               isCBT(root.right, 2 * index + 2, totalNodes);
    }

  
    private boolean isMaxOrder(Node root) {
        if (root == null) return true;

        
        if (root.left == null && root.right == null)
            return true;

        
        if (root.right == null)
            return root.data >= root.left.data &&
                   isMaxOrder(root.left);

        
        return (root.data >= root.left.data &&
                root.data >= root.right.data &&
                isMaxOrder(root.left) &&
                isMaxOrder(root.right));
    }

    public boolean isHeap(Node tree) {
        int totalNodes = countNodes(tree);

        return isCBT(tree, 0, totalNodes) && 
               isMaxOrder(tree);
    }
}
