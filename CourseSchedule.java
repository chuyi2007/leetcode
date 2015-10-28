public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer>[] dependents = new Set[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            dependents[i] = new HashSet<>();
        }
        for (int i = 0; i < prerequisites.length; ++i) {
            int[] edge = prerequisites[i];
            dependents[edge[1]].add(edge[0]);
        }
        
        int[] numOfPrere = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            for (int j: dependents[i]) {
                numOfPrere[j]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < numCourses; ++i) {
            if (numOfPrere[i] == 0) {
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int course = q.poll();
            for (int i: dependents[course]) {
                if (--numOfPrere[i] == 0) {
                    q.offer(i);
                }
            }
            --numCourses;
        }
        return numCourses == 0;
    }
}
