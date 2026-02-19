/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/
class Solution {
    Node removeDuplicates(Node head) {

        if (head == null)
            return null;

        Node current = head;

        while (current != null && current.next != null) {

            if (current.data == current.next.data) {
                // Skip duplicate
                current.next = current.next.next;
            } 
            else {
                current = current.next;
            }
        }

        return head;
    }
}
