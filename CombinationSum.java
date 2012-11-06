public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //sort the list, so identical numbers will be consecutive
        Arrays.sort(candidates);
        int size = candidates.length;
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < size; i++){
            ArrayList<Integer> result = new ArrayList<Integer>();
            dividedSum(candidates, target, i, result, results);
        }
        return results;
    }
    
    //only need to consider first element of duplicate elements
    //all values > 0
    public void dividedSum(int[] candidates, int target, int index,
        ArrayList<Integer> result,
        ArrayList<ArrayList<Integer>> results){
        //first number
        int base = candidates[index];
        //smaller to bigger, so we don't need to iterate more
        int loopNum = target/base;
        
        for(int i = 1; i <= loopNum; i++){
            //minus all the number which are possible pre-elements of the result
            for(int j = 0; j < i; j++)
                result.add(base);
            int tmpTarget = target - base * i;
            
            //index is the current index of the array
            //with tmpTarget > base, which means possibly we need to iterate more
            if(tmpTarget > base && index < candidates.length - 1)
                dividedSum(candidates, tmpTarget, index + 1, result, results);
            //find a result set
            else if(tmpTarget == 0){
                ArrayList<Integer> finalResult = new ArrayList<Integer>();
                for(int val: result)
                    finalResult.add(val);
                results.add(finalResult);
            }
            //remove all the used elements from the result set
            for(int j = 0; j < i; j++)
                result.remove(result.size() - 1);
            //without substract element from current index, do next recursion
            if(result.size() != 0 && i == loopNum && index < candidates.length - 1){
                dividedSum(candidates, target, index + 1, result, results);
            }
        }
    }
}