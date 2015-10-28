public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> singleCombination = new ArrayList<>();
        combinationSum3(combinations, singleCombination, n, k, 1);
        return combinations;
    }
    
    public void combinationSum3(
        List<List<Integer>> combinations,
        List<Integer> singleCombination,
        int n,
        int k,
        int level
    ) {
        if (n == 0 && k == 0) {
            combinations.add(new ArrayList<>(singleCombination));
        } else if (n > 0 && k > 0) {
            for (int i = level; i <= 9; ++i) {
                singleCombination.add(i);
                combinationSum3(combinations, singleCombination, n - i, k - 1, i + 1);
                singleCombination.remove(singleCombination.size() - 1);
            }
        }
    }
}
