//backTracking solution
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        combine(n, k, 1, result, results);
        return results;
    }
    
    public void combine(int n, int k, int index,
    ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results){
        for(int i = index; i <= n; ++i){
            result.add(i);
            if(k > 1)
                combine(n, k - 1, i + 1, result, results);
            else
                results.add(new ArrayList<Integer>(result));
            result.remove(result.size() - 1);
        }
    }
}

//recursion
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