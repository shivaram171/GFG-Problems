/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

// class Solution {
//     int diameter(Node root) {
//         // Your code here
        
//     }
// }



class Solution {
    int res; // to store diameter
    
    int diameter(Node root) {
        res = 0;
        height(root);
        return res;
    }
    
    // returns height in terms of edges
    int height(Node node) {
        if (node == null) return 0;
        
        int left = height(node.left);
        int right = height(node.right);
        
        // update diameter (longest path in terms of edges)
        res = Math.max(res, left + right);
        
        // height = 1 + max(left, right) [1 edge downwards]
        return 1 + Math.max(left, right);
    }
}
