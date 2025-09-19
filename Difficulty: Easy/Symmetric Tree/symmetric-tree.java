/*
class Node{
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
    public boolean isSymmetric(Node root) {
        // Code here
        if (root==null) return true;
        
        return ismirror(root.left, root.right);
    }
    
    boolean ismirror(Node n1, Node n2){
        
        if (n1==null && n2==null) return true;
         if (n1==null || n2==null) return false;
    
    return (n1.data==n2.data) &&
    ismirror(n1.left,n2.right) &&
    ismirror(n1.right,n2.left);    
    }
}