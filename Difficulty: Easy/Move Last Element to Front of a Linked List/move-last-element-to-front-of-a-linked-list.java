/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/
class Solution {
    public static Node moveToFront(Node head) {
        // code here
        if(head==null || head.next==null) return head;
        
        Node curr = head;
        Node prev = null;
     
        while( curr.next != null){
            prev = curr;
            curr = curr.next;
        }
           prev.next=null;
        curr.next=head;
        // head=curr;
     
        
        
        return curr;
    } 
}
