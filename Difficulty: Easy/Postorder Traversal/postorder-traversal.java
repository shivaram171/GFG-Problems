/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(Node node, ArrayList<Integer> result) {
        if (node == null) return;

        // 1. Traverse left subtree
        postorderHelper(node.left, result);

        // 2. Traverse right subtree
        postorderHelper(node.right, result);

        // 3. Visit root
        result.add(node.data);
    }
}
