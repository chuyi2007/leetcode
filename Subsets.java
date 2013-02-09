//BackTracking Solution, O(2^N)
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> bt = new ArrayList<Integer>();
        bt.add(-1);
        Arrays.sort(S);
        subsets(S, 0, bt, results);
        return results;
    }
    
    public void subsets(int[] S, int level, ArrayList<Integer> bt, 
    ArrayList<ArrayList<Integer>> results){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 1; i < bt.size(); ++i){
            result.add(S[bt.get(i)]);
        }
        results.add(result);
        for(int i = bt.get(level) + 1; i < S.length; ++i){
            bt.add(i);
            subsets(S, level + 1, bt, results);
            bt.remove(bt.size() - 1);
        }
    }
}

//Recursion Solution, O(2^N)
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        return subsets(S, 0);
    }
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S, int index){
        ArrayList<ArrayList<Integer>> results 
        = new ArrayList<ArrayList<Integer>>();
        if(index == S.length){
            results.add(new ArrayList<Integer>());
        }
        else if (index < S.length){
            results = subsets(S, index + 1);
            int size = results.size();
            for(int i = 0; i < results.size(); ++i){
                ArrayList<Integer> result = new ArrayList<Integer>(results.get(i));
                result.add(S[index]);
                results.add(result);
            }
        }
        return results;
    }
}