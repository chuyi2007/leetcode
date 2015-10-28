public class Solution {
    public int numTrees(int n) {
        int[] numOfTrees = new int[n + 1];
        numOfTrees[0] = 1;
        numOfTrees[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int left = 0; left < i; ++left) {
                numOfTrees[i] += numOfTrees[left] * numOfTrees[i - 1 - left];
            }
        }
        return numOfTrees[n];
    }
}
