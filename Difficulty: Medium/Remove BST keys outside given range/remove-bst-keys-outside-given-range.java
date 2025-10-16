/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {
    public Node removekeys(Node root, int l, int r) {
        // Base Case
        if (root == null) return null;
        
        // If current node's value is less than l, discard left subtree
        root.right = removekeys(root.right, l, r);
        root.left = removekeys(root.left, l, r);
        
        if (root.data < l) {
            return root.right;
        }
        
        // If current node's value is greater than r, discard right subtree
        if (root.data > r) {
            return root.left;
        }
        
        // Node is within range
        return root;
    }
}
