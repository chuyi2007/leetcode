public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] mins = new int[n];
        for (int j = 0; j < n; ++j) {
            mins[j] = triangle.get(n - 1).get(j);
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                mins[j] = Math.min(mins[j], mins[j + 1]) + triangle.get(i).get(j);
            }
        }
        return mins[0];
    }
}
