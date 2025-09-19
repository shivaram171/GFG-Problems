/*
node class of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Tree {
    // Function to check whether a binary tree is foldable or not.
    boolean IsFoldable(Node node) {
        if (node == null) return true; // empty tree is foldable
        return isMirror(node.left, node.right);
    }

    // Helper function to check mirror structure
    boolean isMirror(Node n1, Node n2) {
        // Case 1: Both null
        if (n1 == null && n2 == null) return true;

        // Case 2: One null, other not
        if (n1 == null || n2 == null) return false;

        // Case 3: Check cross children
        return isMirror(n1.left, n2.right) &&
               isMirror(n1.right, n2.left);
    }
}
