//O(N^k), where target is N, k is number of candidates
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> bt = new ArrayList<Integer>();
        bt.add(0);
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, bt, results);
        return results;
    }
    
    public void combinationSum(int[] candidates, int target, int index, ArrayList<Integer> bt,
                               ArrayList<ArrayList<Integer>> results) {
        if (target == 0) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (int i = 1; i < bt.size(); ++i) {
                result.add(candidates[bt.get(i)]);
            }
            results.add(result);
        }
        else if (target > 0) {
            for (int i = bt.get(index); i < candidates.length; ++i) {
                bt.add(i);
                combinationSum(candidates, target - candidates[i], index + 1, bt, results);
                bt.remove(bt.size() - 1);
            }
        }
    }
}