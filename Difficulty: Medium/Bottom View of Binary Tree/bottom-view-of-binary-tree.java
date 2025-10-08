import java.util.*;

class Solution {
    static class Pair {
        Node node;
        int hd; // horizontal distance
        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        // Map: horizontal distance → node data
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            Node node = curr.node;
            int hd = curr.hd;

            // overwrite to ensure bottommost node stays
            map.put(hd, node.data);

            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
        }

        // Extract values in order of increasing hd
        for (int val : map.values()) {
            res.add(val);
        }

        return res;
    }
}
