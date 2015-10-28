public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer>[] dependents = new Set[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            dependents[i] = new HashSet<>();
        }
        for (int i = 0; i < prerequisites.length; ++i) {
            int[] edge = prerequisites[i];
            dependents[edge[1]].add(edge[0]);
        }
        int[] numPrere = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            for (int j: dependents[i]) {
                ++numPrere[j];
            }
        }
        
        List<Integer> order = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (numPrere[i] == 0) {
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int course = q.poll();
            order.add(course);
            for (int i: dependents[course]) {
                if (--numPrere[i] == 0) {
                    q.offer(i);
                }
            }
        }
        
        return order.size() == numCourses ? convertToArray(order) : new int[0];
    }
    
    public int[] convertToArray(List<Integer> order) {
        int[] array = new int[order.size()];
        for (int i = 0; i < order.size(); ++i) {
            array[i] = order.get(i);
        }
        return array;
    }
}
