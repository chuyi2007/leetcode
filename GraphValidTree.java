public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        
        for (int i = 0; i < edges.length; ++i) {
            int x = unionFind(parents, edges[i][0]);
            int y = unionFind(parents, edges[i][1]);
            if (x == y) {
                return false;
            }
            parents[x] = y;
        }
        // For disjoined edges
        return edges.length == n - 1;
    }
    
    public int unionFind(int[] parents, int i) {
        if (parents[i] == -1) {
            return i;
        }
        return unionFind(parents, parents[i]);
    }
}
