/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        map.put(clone.label, clone);
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            for (UndirectedGraphNode ne: cur.neighbors) {
                if (!map.containsKey(ne.label)){
                    map.put(ne.label, new UndirectedGraphNode(ne.label));
                    q.offer(ne);
                }
                map.get(cur.label).neighbors.add(map.get(ne.label));
            }
        }
        return clone;
    }
}
