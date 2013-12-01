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
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (node == null)
            return null;
        
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(root.label, root);
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.offer(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode n = q.poll();
            for (UndirectedGraphNode c: n.neighbors) {
                if (map.containsKey(c.label)) {
                    map.get(n.label).neighbors.add(map.get(c.label));
                }
                else {
                    UndirectedGraphNode clone = new UndirectedGraphNode(c.label);
                    map.get(n.label).neighbors.add(clone);
                    map.put(clone.label, clone);
                    q.offer(c);
                }
            }
        }
        
        return root;
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