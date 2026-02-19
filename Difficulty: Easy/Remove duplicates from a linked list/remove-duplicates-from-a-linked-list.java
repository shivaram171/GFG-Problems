/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

import java.util.HashSet;

class Solution {
    public Node removeDuplicates(Node head) {

        if (head == null)
            return null;

        HashSet<Integer> set = new HashSet<>();

        Node curr = head;
        Node prev = null;

        while (curr != null) {

            if (set.contains(curr.data)) {
                // Duplicate found → remove node
                prev.next = curr.next;
            } 
            else {
                set.add(curr.data);
                prev = curr;
            }

            curr = curr.next;
        }

        return head;
    }
}
