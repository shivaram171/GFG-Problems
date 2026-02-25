/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    
    // Helper function that returns carry
    private int add(Node head) {
        // Base case: if last node
        if (head == null)
            return 1;   // add 1 here
        
        int carry = add(head.next);
        
        int sum = head.data + carry;
        head.data = sum % 10;
        
        return sum / 10;   // return carry
    }
    
    public Node addOne(Node head) {
        
        int carry = add(head);
        
        // If carry still exists, create new node
        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = head;
            head = newNode;
        }
        
        return head;
    }
}