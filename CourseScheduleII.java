public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> dependents = new HashMap<>();
        int[] degree = new int[numCourses];
        for (int[] pre : prerequisites) {
            if (!dependents.containsKey(pre[1])) {
                dependents.put(pre[1], new ArrayList<>());
            }
            dependents.get(pre[1]).add(pre[0]);
            degree[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (degree[i] == 0) {
                q.offer(i);
                order.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (dependents.containsKey(cur)) {
                for (int dep : dependents.get(cur)) {
                    degree[dep]--;
                    if (degree[dep] == 0) {
                        q.offer(dep);
                        order.add(dep);
                    }
                }
            }
        }
        if (order.size() != numCourses) {
            return new int[0];
        }
        int[] res = new int[order.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = order.get(i);
        }
        return res;
    }
}
