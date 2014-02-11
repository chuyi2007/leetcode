/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.offer(node);
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        map.put(head.label, head);
        while (!q.isEmpty()) {
            UndirectedGraphNode n1 = q.poll();
            for (UndirectedGraphNode n : n1.neighbors) {
                if (!map.containsKey(n.label)) {
                    map.put(n.label, new UndirectedGraphNode(n.label));
                    q.offer(n);
                }
                map.get(n1.label).neighbors.add(map.get(n.label));
            }
        }
        return head;
    }


    //DFS solution, time limitation
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        return cloneGraph(node, map);
    }
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
        if (node == null)
            return null;
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(root.label, root);
        for (UndirectedGraphNode neighbor: node.neighbors) {
            if (map.containsKey(neighbor.label))
                root.neighbors.add(map.get(neighbor.label));
            else
                root.neighbors.add(cloneGraph(neighbor));
        }
        return root;
    }
}