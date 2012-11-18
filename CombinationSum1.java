import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        int size = candidates.length;
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < size; i++){
            ArrayList<Integer> result = new ArrayList<Integer>();
            dividedSum(candidates, target, i, result, results);
        }
        return results;
    }
    
    public void dividedSum(int[] candidates, int target, int index,
        ArrayList<Integer> result,
        ArrayList<ArrayList<Integer>> results){     
        int base = candidates[index];
        int loopNum = target/base;
        
        for(int i = 1; i <= loopNum; i++){
            for(int j = 0; j < i; j++)
                result.add(base);
            int tmpTarget = target - base * i;
            
            if(tmpTarget > base && index < candidates.length - 1){
                dividedSum(candidates, tmpTarget, index + 1, result, results);
            }
            else if(tmpTarget == 0){
                ArrayList<Integer> finalResult = new ArrayList<Integer>();
                for(int val: result)
                    finalResult.add(val);
                results.add(finalResult);
            }
            for(int j = 0; j < i; j++)
                result.remove(result.size() - 1);
            if(result.size() != 0 && i == loopNum && index < candidates.length - 1){
                dividedSum(candidates, target, index + 1, result, results);
            }
        }
    }
}