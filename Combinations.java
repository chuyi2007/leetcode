public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> singleCombination = new ArrayList<>();
        combine(combinations, singleCombination, n, k, 1);
        return combinations;
    }
    
    public void combine(
        List<List<Integer>> combinations,
        List<Integer> singleCombination,
        int n,
        int k,
        int level
    ) {
        for (int i = level; i <= n; ++i) {
            singleCombination.add(i);
            if (k > 1) {
                combine(combinations, singleCombination, n, k - 1, i + 1);
            }
            else {
                combinations.add(new ArrayList<>(singleCombination));
            }
            singleCombination.remove(singleCombination.size() - 1);
        }
    }
}

//recursion, O(N!/K!)
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        List<List<Integer>> results = new ArrayList<>();
        if (k == 1) {
            for (int i = n; i > 0; --i) {
                List<Integer> result = new ArrayList<>();
                result.add(i);
                results.add(result);
            }
        }
        else {
            for (int i = n; i > 0; --i) {
                for (List<Integer> result: combine(i - 1, k - 1)) {
                    result.add(i);
                    results.add(result);
                }
            }
        }
        return results;
    }
}
