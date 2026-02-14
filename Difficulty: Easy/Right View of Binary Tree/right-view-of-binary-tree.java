/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> rightView(Node root) {
        // code here
    ArrayList<Integer> result = new ArrayList<>();
    
    Queue <Node> q = new LinkedList<>();
    
    if(root == null){
        return result;
    }
    q.add(root);
    while(!q.isEmpty()){
    
        int size = q.size();
        for(int i =0; i<size;i++){
            Node curr = q.poll();
        
            if(i==size-1){
            
            result.add(curr.data);
        }
        if(curr.left!=null){
            q.add(curr.left);
        }
        if(curr.right !=  null){
            q.add(curr.right);
        }
    }
 
    }
       return result;
}
}