import java.util.*;

class Solution {
    int preIndex = 0;
    int[] preorder, postorder;
    Map<Integer, Integer> postMap;

    public Node constructTree(int[] pre, int[] post) {
        this.preorder = pre;
        this.postorder = post;
        this.postMap = new HashMap<>();

        // store postorder indices for quick lookup
        for (int i = 0; i < post.length; i++) {
            postMap.put(post[i], i);
        }

        return buildTree(0, post.length - 1);
    }

    private Node buildTree(int start, int end) {
        if (preIndex >= preorder.length || start > end) return null;

        // Create root
        Node root = new Node(preorder[preIndex++]);

        // If this node has no children (leaf node)
        if (start == end || preIndex >= preorder.length)
            return root;

        // Next node in preorder is left child
        int leftRootVal = preorder[preIndex];
        int leftRootIdx = postMap.get(leftRootVal);

        // Build left and right subtrees recursively
        root.left = buildTree(start, leftRootIdx);
        root.right = buildTree(leftRootIdx + 1, end - 1);

        return root;
    }
}
