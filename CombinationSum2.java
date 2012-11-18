import java.util.Arrays;
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        int previousInt = -1;
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < num.length; i++){
            if(previousInt != num[i]){
                previousInt = num[i];
                ArrayList<Integer> result = new ArrayList<Integer>();
                substractSum(num, i, target, result, results);
            }
        }
        return results;
    }
    
    public void substractSum(int[] num, int index, int target,
    ArrayList<Integer> result, 
    ArrayList<ArrayList<Integer>> results){      
        
        int base = num[index];
        if(target == 0){
            ArrayList<Integer> finalResult = new ArrayList<Integer>();
                for(int val: result)
                    finalResult.add(val);
            results.add(finalResult);
        }
        else if (target == base && index == num.length - 1){
            
        }
        else if (target >= base && index < num.length - 1){
            int tmpTarget = target - base;
            result.add(base);
            substractSum(num, index + 1, tmpTarget, result, results);
        }
        else if(result.size() != 0){
            int tmpTarget = target + result.get(result.size() - 1);
            result.remove(result.size() - 1);
            substractSum(num, index, tmpTarget, result, results);
        }
    }
}