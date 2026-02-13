/*
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int height(Node root) {
        
        // Base case
        if (root == null)
            return -1;
        
        // Height of left subtree
        int leftHeight = height(root.left);
        
        // Height of right subtree
        int rightHeight = height(root.right);
        
        // Return max height + 1 (for current node)
        return Math.max(leftHeight, rightHeight)+1;
    }
}
