//I don't know, take a guess?
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> bt = new ArrayList<Integer>();
        bt.add(-1);
        Arrays.sort(num);
        combinationSum2(num, target, 0, bt, results);
        return results;
    }
    
    public void combinationSum2(int[] num, int target, int index, ArrayList<Integer> bt,
                                ArrayList<ArrayList<Integer>> results){
        if(target == 0){
            ArrayList<Integer> result = new ArrayList<Integer>();
            for(int i = 1; i < bt.size(); ++i){
                result.add(num[bt.get(i)]);
            }
            results.add(result);
        }
        else if(target > 0){
            for(int i = bt.get(index) + 1; i < num.length; ++i){
                bt.add(i);
                combinationSum2(num, target - num[i], index + 1, bt, results);
                bt.remove(bt.size() - 1);
                while(i < num.length - 1 && num[i] == num[i + 1])
                    ++i;
            }
        }
    }
}