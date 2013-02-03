public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        loopCombine(n, k, 0, 1, result, results);
        return results;
    }
    
    public void loopCombine(int n, int k, int kCount, int index,
    ArrayList<Integer> result,
    ArrayList<ArrayList<Integer>> results){
        for(int i = index; i <= n; i++){
            result.add(i);
            if(kCount == k - 1){
                ArrayList<Integer> finalResult = new ArrayList<Integer>();
                for(int val: result)
                    finalResult.add(val);
                results.add(finalResult);
            }
            if(kCount < k - 1){
                loopCombine(n, k, kCount + 1, i + 1, result, results);
            }
            result.remove(kCount);
        }
    }
}

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(k == 1){
            for(int i = n; i > 0; --i){
                ArrayList<Integer> result = new ArrayList<Integer>();
                result.add(i);
                results.add(result);
            }
        }
        else{
            for(int i = n; i > 0; --i){
                for(ArrayList<Integer> result: combine(i - 1, k - 1)){
                    result.add(i);
                    results.add(result);
                }
            }
        }
        return results;
    }
}