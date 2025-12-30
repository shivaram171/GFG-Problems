class Solution {

    static class Carry {
        int val = 0;
    }

    public Node addTwoLists(Node head1, Node head2) {

        // Remove leading zeros
        head1 = removeZeros(head1);
        head2 = removeZeros(head2);

        // Get lengths
        int len1 = length(head1);
        int len2 = length(head2);

        // Pad smaller list with zeros
        if (len1 < len2)
            head1 = padZeros(head1, len2 - len1);
        else if (len2 < len1)
            head2 = padZeros(head2, len1 - len2);

        Carry carry = new Carry();
        Node result = addRec(head1, head2, carry);

        // If carry remains, add at front
        if (carry.val > 0) {
            Node node = new Node(carry.val);
            node.next = result;
            result = node;
        }

        return result;
    }

    // Recursive helper
    private Node addRec(Node n1, Node n2, Carry carry) {
        if (n1 == null && n2 == null)
            return null;

        Node next = addRec(n1.next, n2.next, carry);

        int sum = n1.data + n2.data + carry.val;
        Node curr = new Node(sum % 10);
        carry.val = sum / 10;

        curr.next = next;
        return curr;
    }

    // Utilities
    private int length(Node head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private Node padZeros(Node head, int count) {
        while (count-- > 0) {
            Node node = new Node(0);
            node.next = head;
            head = node;
        }
        return head;
    }

    private Node removeZeros(Node head) {
        while (head != null && head.data == 0)
            head = head.next;
        return head == null ? new Node(0) : head;
    }
}
