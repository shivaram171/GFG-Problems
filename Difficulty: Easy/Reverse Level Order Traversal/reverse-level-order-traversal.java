/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Tree {
    public ArrayList<Integer> reverseLevelOrder(Node root) {
        
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            stack.push(curr);
            
            // IMPORTANT: enqueue right first, then left
            if (curr.right != null)
                queue.offer(curr.right);
            
            if (curr.left != null)
                queue.offer(curr.left);
        }
        
        while (!stack.isEmpty()) {
            result.add(stack.pop().data);
        }
        
        return result;
    }
}
